package dev.razil.lilhub.data

import dev.razil.lilhub.api.GitHubService
import dev.razil.lilhub.api.ListResponse
import dev.razil.lilhub.data.model.GitHubRepo
import javax.inject.Inject

/**
 * Repository acts as an intermediary between the view model and the data source and consequently hides the implantation
 * details of how the data is fetched or persisted.
 *
 * *Note: This class does not represent a __git__ repository.*
 *
 * @param service An instance of [GitHubService]
 */
class Repository @Inject constructor(private val service: GitHubService) {
    suspend fun search(query: String, repoCount: Int, after: String? = null): ListResponse<GitHubRepo> {
        return service.search(query, repoCount, after)
    }
}
