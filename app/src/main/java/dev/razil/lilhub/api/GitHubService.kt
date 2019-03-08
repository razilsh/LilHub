package dev.razil.lilhub.api

import com.apollographql.apollo.ApolloClient
import javax.inject.Inject

/**
 * Uses a pre-configured instance of [ApolloClient] to request data from GitHub's api.
 *
 * @param apolloClient An instance of [ApolloClient]
 */
class GitHubService @Inject constructor(private val apolloClient: ApolloClient)
