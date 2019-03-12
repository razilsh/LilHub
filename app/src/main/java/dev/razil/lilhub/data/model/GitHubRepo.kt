package dev.razil.lilhub.data.model

import org.threeten.bp.Instant

data class GitHubRepo(
    val id: String,
    val name: String,
    val url: String,
    val nameWithOwner: String,
    val language: Language?,
    val description: String,
    val stars: Int = 0,
    val forks: Int = 0,
    val createdAt: Instant?,
    val updatedAt: Instant?
)
