package dev.razil.lilhub.common

import dev.razil.lilhub.common.Result.Err
import dev.razil.lilhub.common.Result.Ok
import kotlinx.coroutines.coroutineScope

/**
 * [Result] represents either success [Ok] or failure [Err]. Mostly used for operations that could possibly fail/throw
 * an exception e.g persisting data to local storage or fetching data from the network.
 *
 */
sealed class Result<out V : Any, out E : Throwable> {
    abstract fun isOk(): Boolean
    abstract fun isErr(): Boolean

    /**
     * Represents the success case of a result
     *
     * @param value Contains the success value
     */
    data class Ok<V : Any>(val value: V) : Result<V, Nothing>() {
        override fun isOk() = true

        override fun isErr() = false
    }

    /**
     * Represent the failure case of a result
     *
     * @param error Contains an exception
     */
    data class Err<E : Throwable>(val error: E) : Result<Nothing, E>() {
        override fun isOk() = false

        override fun isErr() = true
    }

    @Suppress("UNCHECKED_CAST")
    companion object {
        fun <V : Any> ok(t: V) = Ok(t)

        fun <E : Throwable> err(e: E) = Err(e)

        fun <V : Any, E : Throwable> of(f: () -> V): Result<V, E> = try {
            ok(f())
        } catch (e: Throwable) {
            err(e as E)
        }

        suspend fun <V : Any, E : Throwable> ofCo(f: suspend () -> V): Result<V, E> =
            coroutineScope {
                try {
                    ok(f())
                } catch (e: Throwable) {
                    err(e as E)
                }
            }
    }
}
