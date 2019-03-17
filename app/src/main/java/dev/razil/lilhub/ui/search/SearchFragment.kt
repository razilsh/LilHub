package dev.razil.lilhub.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.material.textfield.TextInputLayout
import dev.razil.lilhub.LilHubApp
import dev.razil.lilhub.R
import dev.razil.lilhub.databinding.SearchFragmentBinding
import dev.razil.lilhub.ui.extensions.onSubmit
import dev.razil.lilhub.ui.extensions.showKeyboard
import javax.inject.Inject

class SearchFragment : Fragment() {

    init {
        LilHubApp.get().inject(this)
    }

    @Inject
    lateinit var factory: SearchViewModelFactory
    private val viewModel: SearchViewModel by viewModels { factory }

    private lateinit var binding: SearchFragmentBinding
    private lateinit var searchText: TextInputLayout

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.search_fragment, container, false)
        searchText = binding.searchText
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewModel = this.viewModel
        binding.lifecycleOwner = this

        showKeyboard(searchText)
        searchText.onSubmit(viewModel::search)

        val repoListView = binding.repoList
        val controller = PagedListGitHubRepoController()
        repoListView.setController(controller)

        viewModel.repoList.observe(viewLifecycleOwner, Observer {
            controller.submitList(it)
        })
    }
}
