package dev.razil.lilhub

import dev.razil.lilhub.common.created
import dev.razil.lilhub.common.getName
import dev.razil.lilhub.common.toModel
import dev.razil.lilhub.common.updated
import dev.razil.lilhub.fragment.GitHubRepoDTO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource

class ModelMapperTest {

    @ParameterizedTest
    @MethodSource("dev.razil.lilhub.TestDataProvider#provide")
    fun `Check that values from dto to model are mapped correctly`(dto: GitHubRepoDTO) {
        val model = dto.toModel()
        Assertions.assertEquals(dto.id(), model.id)
        Assertions.assertEquals(dto.getName(), model.name)
        Assertions.assertEquals(dto.nameWithOwner(), model.nameWithOwner)
        Assertions.assertEquals(dto.owner().id(), model.owner.id)
        Assertions.assertEquals(dto.owner().login(), model.owner.login)
        Assertions.assertEquals(dto.owner().avatarUrl(), model.owner.avatarUrl)
        Assertions.assertEquals(dto.url(), model.url)
        Assertions.assertEquals(dto.description(), model.description)
        Assertions.assertEquals(dto.created(), model.createdAt)
        Assertions.assertEquals(dto.updated(), model.updatedAt)
        Assertions.assertEquals(dto.primaryLanguage()?.id(), model.language?.id)
        Assertions.assertEquals(dto.primaryLanguage()?.name(), model.language?.name)
        Assertions.assertEquals(dto.primaryLanguage()?.color(), model.language?.color)
        Assertions.assertEquals(dto.stargazers().totalCount(), model.stars)
    }
}
