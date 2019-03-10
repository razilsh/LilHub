package dev.razil.lilhub

import dev.razil.lilhub.fragment.GitHubRepoDTO
import org.junit.jupiter.params.provider.Arguments
import uk.co.jemos.podam.api.PodamFactoryImpl
import java.util.stream.Stream

class TestDataProvider {
    companion object {
        @JvmStatic
        fun provide(): Stream<Arguments>? {
            val factory = PodamFactoryImpl()
            val args = mutableListOf<Arguments>()
            repeat(1000) {
                val dto = factory.manufacturePojoWithFullData(GitHubRepoDTO::class.java)
                args += Arguments.of(dto)
            }
            return args.stream()
        }
    }
}
