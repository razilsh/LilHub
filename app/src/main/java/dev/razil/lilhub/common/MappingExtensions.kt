package dev.razil.lilhub.common

import com.apollographql.apollo.api.Response
import dev.razil.lilhub.SearchQuery
import dev.razil.lilhub.api.ListResponse
import dev.razil.lilhub.data.model.GitHubRepo
import dev.razil.lilhub.data.model.Language
import dev.razil.lilhub.fragment.GitHubRepoDTO
import kotlinx.coroutines.Deferred
import org.threeten.bp.Instant
import org.threeten.bp.format.DateTimeParseException

/**
 * Contains functions to convert between models and DTOs.
 */

fun GitHubRepoDTO.getName(): String {
    val parts = nameWithOwner().split("/")
    return if (parts.isEmpty()) nameWithOwner() else parts[0]
}

fun GitHubRepoDTO.created() = parseDate(createdAt().toString())

fun GitHubRepoDTO.updated() = parseDate(updatedAt().toString())

fun parseDate(dateString: String): Instant? = try {
    Instant.parse(dateString)
} catch (e: DateTimeParseException) {
    null
}

suspend fun Deferred<Response<SearchQuery.Data>>.toListResponse(): ListResponse<GitHubRepo> {
    val apolloResponse = this.await()
    val search = apolloResponse.data()?.search()
    val after = search?.pageInfo()?.endCursor()

    val dto = search?.nodes()?.mapNotNull { it.fragments().gitHubRepoDTO() } ?: emptyList()
    val repos = dto.toModel()
    return ListResponse(repos, after)
}

fun List<GitHubRepoDTO>.toModel() = map(GitHubRepoDTO::toModel)

fun GitHubRepoDTO.toModel() = GitHubRepo(
    id = id(),
    name = getName(),
    url = url(),
    nameWithOwner = nameWithOwner(),
    language = primaryLanguage()?.toModel(),
    description = description() ?: "",
    stars = stargazers().totalCount(),
    createdAt = created(),
    updatedAt = updated()
)

fun GitHubRepoDTO.PrimaryLanguage.toModel(): Language {
    val id = id()
    val name = name()
    val color = color()
    return Language(id, name, color)
}
