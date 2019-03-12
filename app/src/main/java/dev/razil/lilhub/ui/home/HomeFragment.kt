package dev.razil.lilhub.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.epoxy.EpoxyRecyclerView
import dev.razil.lilhub.LilHubApp
import dev.razil.lilhub.R
import dev.razil.lilhub.RepoItemBindingModel_
import dev.razil.lilhub.common.Result
import dev.razil.lilhub.data.model.GitHubRepo
import dev.razil.lilhub.databinding.HomeFragmentBinding
import dev.razil.lilhub.ui.SpacesItemDecoration
import timber.log.Timber
import javax.inject.Inject

class HomeFragment : Fragment() {
    @Inject
    lateinit var viewModelFactory: HomeViewModelFactory
    private lateinit var viewModel: HomeViewModel

    private lateinit var binding: HomeFragmentBinding
    private lateinit var repoList: EpoxyRecyclerView
    private lateinit var dividerItemDecoration: DividerItemDecoration

    init {
        LilHubApp.get().inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(inflater, R.layout.home_fragment, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        dividerItemDecoration = SpacesItemDecoration(
            context = requireContext(),
            orientation = LinearLayoutManager.VERTICAL
        )
        dividerItemDecoration.setDrawable(requireContext().getDrawable(R.drawable.divider)!!)

        repoList = binding.repoList

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        viewModel.trendingRepos.observe(viewLifecycleOwner, Observer { result ->
            when (result) {
                is Result.Ok -> updateUI(result.value)
                is Result.Err -> {
                    Timber.e(result.error)
                }
            }
        })
    }

    private fun updateUI(repos: List<GitHubRepo>) {

        repoList.addItemDecoration(dividerItemDecoration)
        repoList.buildModelsWith { controller ->
            repos.forEach { gitHubRepo ->
                RepoItemBindingModel_().id(gitHubRepo.id).repo(gitHubRepo).addTo(controller)
            }
        }
    }
}
