package com.uranium.gitlist.main.presentation.repositorieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.uranium.gitlist.databinding.FragmentRepositoriesListBinding
import org.koin.androidx.viewmodel.ext.android.viewModel


internal typealias RepositoryListener = (id: Int) -> Unit

class RepositoriesListFragment : Fragment() {

    private val layoutManager by lazy { LinearLayoutManager(context) }
    private var loading = false
    private lateinit var binding: FragmentRepositoriesListBinding
    private val viewModel: RepositoriesListViewModel by viewModel()
    private val adapter: RepositoriesListAdapter2 by lazy {
        RepositoriesListAdapter2() {
            Toast.makeText(context, "$it", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRepositoriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupStateObserver()
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        binding.repositoriesList.adapter = adapter
        setupEndlessList()
    }

    private fun setupStateObserver() {
        viewModel.getUser().observe(viewLifecycleOwner) { state ->
            showLoading(state.showLoading)
            fillRepositoriesList(state.repositoriesList)
        }
    }

    private fun showLoading(showLoading: Boolean) {
        loading = showLoading
        binding.loading.visibility = View.INVISIBLE.takeUnless { showLoading } ?: View.VISIBLE
    }

    private fun fillRepositoriesList(repositoriesList: List<GitRepositoryState>?) {
        binding.repositoriesList.layoutManager = layoutManager
            repositoriesList?.let { adapter.updateList(it) }
    }

    private fun setupEndlessList() {
        binding.repositoriesList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (layoutManager.findLastVisibleItemPosition() == adapter.itemCount - 1) {
                        viewModel.getKotlinRepositories()
                }
            }
        })
    }

    companion object {
        fun newInstance() = RepositoriesListFragment()
    }
}