package com.littleapp.news.ui.fragments.toparticles

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.littleapp.news.R
import com.littleapp.news.base.BaseFragment
import com.littleapp.news.common.Resource
import com.littleapp.news.common.viewBinding
import com.littleapp.news.databinding.FragmentTopArticlesBinding
import com.littleapp.news.ui.adapters.TopArticlesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class TopArticlesFragment :
    BaseFragment<FragmentTopArticlesBinding, TopArticlesViewModel>(R.layout.fragment_top_articles) {

    override val binding by viewBinding(FragmentTopArticlesBinding::bind)
    override val viewModel: TopArticlesViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private val adapter = TopArticlesAdapter()

    override fun initialize() {
        binding.recyclerView.adapter = adapter
    }

    override fun setupSubscribes() {
        subscribeToTopArticles()
    }

    private fun subscribeToTopArticles() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.topArticlesState.collect { resource ->
                    when (resource) {
                        is Resource.Error -> {
                            Timber.e(resource.message)
                        }

                        is Resource.Loading -> {
                            // Handle loading state
                        }

                        is Resource.Success -> {
                            adapter.submitList(resource.data.articles)
                        }
                    }
                }
            }
        }
    }
}