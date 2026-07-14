package com.littleapp.news.ui.fragments.everything

import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.littleapp.news.R
import com.littleapp.news.base.BaseFragment
import com.littleapp.news.common.Resource
import com.littleapp.news.common.viewBinding
import com.littleapp.news.databinding.FragmentEverythingBinding
import com.littleapp.news.ui.adapters.EverythingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import timber.log.Timber

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by hiltNavGraphViewModels(R.id.nav_graph)
    private val adapter = EverythingAdapter()

    override fun initialize() {
        binding.recyclerView.adapter = adapter
    }

    override fun setupSubscribes() {
        subscribeToEverything()
    }

    private fun subscribeToEverything() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.everythingState.collect { resource ->
                    when (resource) {
                        is Resource.Error -> {
                            Timber.e(resource.message)
                        }

                        is Resource.Loading -> {
                            // Handle loading state if needed
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