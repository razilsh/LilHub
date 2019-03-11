package dev.razil.lilhub

import androidx.lifecycle.Observer
import dev.razil.lilhub.api.ListResponse
import dev.razil.lilhub.common.Result
import dev.razil.lilhub.data.Repository
import dev.razil.lilhub.data.model.GitHubRepo
import dev.razil.lilhub.ui.home.HomeViewModel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.extension.ExtendWith
import org.threeten.bp.Instant
import org.threeten.bp.LocalDate
import org.threeten.bp.ZoneId
import org.threeten.bp.format.DateTimeFormatter
import org.threeten.bp.temporal.ChronoUnit
import java.util.Locale
import java.util.concurrent.TimeUnit

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@ExtendWith(InstantExecutorExtension::class)
class HomeViewModelTest {

    @Test
    fun testOk() {
        val repository = mockk<Repository>()
        val listResponse = ListResponse<GitHubRepo>(emptyList())
        coEvery { repository.search(any(), any(), any()) } returns listResponse

        val observer = mockk<Observer<Result<List<GitHubRepo>, Exception>>>()
        val viewModel = HomeViewModel(repository)
        viewModel.trendingRepos.observeForever(observer)

        val ok = Result.of<List<GitHubRepo>, Exception> { listResponse.listData }
        verify { observer.onChanged(ok) }
        verify { observer.onChanged(Result.ok(listResponse.listData)) }

        viewModel.trendingRepos.removeObserver(observer)
        Assertions.assertFalse(viewModel.trendingRepos.hasObservers())
    }

    @Test
    fun testErr() {
        val ex = UnsupportedOperationException()
        val repository = mockk<Repository>()
        coEvery { repository.search(any(), any(), any()) } throws ex

        val observer = mockk<Observer<Result<List<GitHubRepo>, Exception>>>()
        val viewModel = HomeViewModel(repository)

        viewModel.trendingRepos.observeForever(observer)

        val err = Result.of<List<GitHubRepo>, Exception> { throw ex }
        verify { observer.onChanged(err) }
        verify { observer.onChanged(Result.err(ex)) }

        viewModel.trendingRepos.removeObserver(observer)
        Assertions.assertFalse(viewModel.trendingRepos.hasObservers())
    }

    @Test
    fun testDate() {
        val now = Instant.now()
        val instant = now.minus(7, ChronoUnit.DAYS)

        val date = DateTimeFormatter.ofPattern("YYYY-MM-dd")
            .withLocale(Locale.ENGLISH)
            .withZone(ZoneId.systemDefault())
            .format(instant)

        val diff = TimeUnit.MILLISECONDS.toDays(now.toEpochMilli() - instant.toEpochMilli())
        Assertions.assertEquals(7L, diff)

        val isValid = LocalDate.parse(date).toString() == date
        Assertions.assertTrue(isValid)
    }
}
