package dev.razil.lilhub

import dev.razil.lilhub.common.Result
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ResultTest {
    @Test
    fun testSuccess() {
        val ok = Result.ok(1)

        val of = Result.of<Int, Exception> {
            return@of 1
        }

        assertTrue(ok.isOk())
        assertTrue(of.isOk())

        assertFalse(ok.isErr())
        assertFalse(of.isErr())
    }

    @Test
    fun testFailure() {
        val err = Result.err(IllegalStateException())

        val of = Result.of<Int, Exception> {
            throw IllegalStateException()
        }

        assertTrue(err.isErr())
        assertTrue(of.isErr())

        assertFalse(err.isOk())
        assertFalse(of.isOk())
    }
}
