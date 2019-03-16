package dev.razil.lilhub.api

sealed class NetworkState {
    object LOADING : NetworkState()
    object LOADED : NetworkState()
    data class ERROR(val error: String?) : NetworkState()
}
