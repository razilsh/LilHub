package dev.razil.lilhub.api

import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Input
import dev.razil.lilhub.SearchQuery
import dev.razil.lilhub.common.toDeferred
import dev.razil.lilhub.common.toListResponse
import javax.inject.Inject

/**
 * Uses a pre-configured instance of [ApolloClient] to request listData from GitHub's api.
 *
 * @param apolloClient An instance of [ApolloClient]
 */
class GitHubService @Inject constructor(private val apolloClient: ApolloClient) {
    suspend fun search(
        query: String,
        repoCount: Int,
        after: String? = null
    ) = apolloClient
        .query(SearchQuery(query, repoCount, Input.fromNullable(after)))
        .toDeferred().toListResponse()
}
