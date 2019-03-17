package dev.razil.lilhub.ui.search

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import dev.razil.lilhub.api.ListResponse
import dev.razil.lilhub.api.NetworkState
import dev.razil.lilhub.common.Result
import dev.razil.lilhub.data.Repository
import dev.razil.lilhub.data.model.GitHubRepo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class PageKeyedGitHubRepoDataSource(
    private val repo: Repository,
    private val scope: CoroutineScope,
    private var query: String
) : PageKeyedDataSource<String, GitHubRepo>() {

    val networkState = MutableLiveData<NetworkState>()

    override fun loadInitial(params: LoadInitialParams<String>, callback: LoadInitialCallback<String, GitHubRepo>) {
        if (query.isBlank()) return
        scope.launch {
            networkState.postValue(NetworkState.LOADING)
            val response: Result<ListResponse<GitHubRepo>, Exception> = Result.ofCo {
                repo.search(query)
            }
            when (response) {
                is Result.Ok -> {
                    callback.onResult(response.value.listData, null, response.value.nextPage)
                    networkState.postValue(NetworkState.LOADED)
                }
                is Result.Err -> {
                    callback.onResult(emptyList(), null, null)
                    networkState.postValue(NetworkState.ERROR(response.error.message))
                }
            }
        }
    }

    override fun loadAfter(params: LoadParams<String>, callback: LoadCallback<String, GitHubRepo>) {
        if (query.isBlank()) return
        scope.launch {
            networkState.postValue(NetworkState.LOADING)
            val response: Result<ListResponse<GitHubRepo>, Exception> = Result.ofCo {
                repo.search(query, after = params.key)
            }

            when (response) {
                is Result.Ok -> {
                    callback.onResult(response.value.listData, response.value.nextPage)
                    networkState.postValue(NetworkState.LOADED)
                }
                is Result.Err -> {
                    callback.onResult(emptyList(), null)
                    networkState.postValue(NetworkState.ERROR(response.error.message))
                }
            }
        }
    }

    override fun loadBefore(
        params: LoadParams<String>,
        callback: LoadCallback<String, GitHubRepo>
    ) = Unit

    fun refresh() {
        invalidate()
    }
}
