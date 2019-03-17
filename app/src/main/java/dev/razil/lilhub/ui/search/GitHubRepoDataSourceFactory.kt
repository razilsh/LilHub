package dev.razil.lilhub.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import dev.razil.lilhub.data.Repository
import dev.razil.lilhub.data.model.GitHubRepo
import kotlinx.coroutines.CoroutineScope
import timber.log.Timber

class GitHubRepoDataSourceFactory(
    private val repo: Repository,
    private val scope: CoroutineScope,
    private var query: String
) :
    DataSource.Factory<String, GitHubRepo>() {
    val source = MutableLiveData<PageKeyedGitHubRepoDataSource>()
    override fun create(): DataSource<String, GitHubRepo> {
        val s = PageKeyedGitHubRepoDataSource(repo, scope, query)
        source.postValue(s)
        return s
    }

    fun search(query: String) {
        this.query = query
        Timber.i("Query = $query")
        source.value?.refresh()
    }
}
