package dev.razil.lilhub.data.model

import java.util.*

data class GitHubRepo(
    val id: String,
    val name: String,
    val nameWithOwner: String,
    val language: Language,
    val description: String,
    val stars: Int,
    val createdAt: Date,
    val updatedAt: Date
)