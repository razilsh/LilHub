package dev.razil.lilhub.api

/**
 * A container class that holds a list returned from the api and the cursor to the next page.
 * [nextPage] will be null if the api doesn't have any more result to return.
 *
 * @param listData List of objects returned from the api
 * @param nextPage Cursor to the next page.
 */
data class ListResponse<T>(val listData: List<T>, val nextPage: String? = null)
