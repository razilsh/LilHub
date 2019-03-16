package dev.razil.lilhub.ui.search

import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.paging.PagedListEpoxyController
import dev.razil.lilhub.RepoItemBindingModel_
import dev.razil.lilhub.data.model.GitHubRepo

class PagedListGitHubRepoController :
    PagedListEpoxyController<GitHubRepo>(diffingHandler = EpoxyAsyncUtil.getAsyncBackgroundHandler()) {
    override fun buildItemModel(currentPosition: Int, item: GitHubRepo?): EpoxyModel<*> {
        return when (item) {
            null -> RepoItemBindingModel_().id(-1)
            else -> RepoItemBindingModel_().id(item.id).repo(item)
        }
    }
}
