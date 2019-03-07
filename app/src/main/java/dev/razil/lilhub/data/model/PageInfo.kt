package dev.razil.lilhub.data.model

data class PageInfo(
    val startCursor: String?,
    val endCursor: String?,
    val hasNextPage: Boolean,
    val hasPreviousPage: Boolean
)
