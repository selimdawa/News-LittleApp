package com.littleapp.news.ui.fragments.toparticles

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.littleapp.news.R
import com.littleapp.news.databinding.FragmentTopArticlesBinding
import com.littleapp.news.base.BaseFragment
import com.littleapp.news.common.Resource
import com.littleapp.news.ui.adapters.TopArticlesAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class TopArticlesFragment :
    BaseFragment<FragmentTopArticlesBinding, TopArticlesViewModel>(R.layout.fragment_top_articles) {

    private var _binding: FragmentTopArticlesBinding? = null
    override val binding get() = _binding!!

    override val viewModel: TopArticlesViewModel by viewModels()
    private val adapter = TopArticlesAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        _binding = FragmentTopArticlesBinding.bind(view)
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribes()
    }

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        subscribesTopArticles()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribesTopArticles() {
        viewModel.fetchTopArticles().observe(viewLifecycleOwner) { resource ->
            when (resource) {
                is Resource.Error -> {
                    Timber.e(resource.message.toString())
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    resource.data?.articles?.let { articles ->
                        adapter.submitList(articles)
                    }
                }
                else -> {}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}