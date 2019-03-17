package dev.razil.lilhub.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import dev.razil.lilhub.api.NetworkState
import dev.razil.lilhub.data.Repository
import dev.razil.lilhub.data.model.GitHubRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import javax.inject.Inject
import kotlin.coroutines.CoroutineContext

class SearchViewModel @Inject constructor(repo: Repository) : ViewModel(), CoroutineScope {

    private val job = Job()
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.IO

    private val dataSourceFactory = GitHubRepoDataSourceFactory(repo, this, "")
    val networkState: LiveData<NetworkState>?
        get() = Transformations.switchMap(dataSourceFactory.source) { it.networkState }

    val repoList = LivePagedListBuilder<String, GitHubRepo>(dataSourceFactory, pagedListConfig).build()

    fun search(query: String) = dataSourceFactory.search(query)

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }

    companion object {
        private val pagedListConfig: PagedList.Config
            get() {
                return PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(2)
                    .setPageSize(3)
                    .build()
            }
    }
}
