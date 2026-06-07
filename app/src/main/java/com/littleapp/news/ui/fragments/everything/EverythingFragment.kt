package com.littleapp.news.ui.fragments.everything

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.littleapp.news.R
import com.littleapp.news.databinding.FragmentEverythingBinding
import com.littleapp.news.base.BaseFragment
import com.littleapp.news.common.Resource
import com.littleapp.news.ui.adapters.EverythingAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class EverythingFragment :
    BaseFragment<FragmentEverythingBinding, EverythingViewModel>(R.layout.fragment_everything) {

    override val binding by viewBinding(FragmentEverythingBinding::bind)
    override val viewModel: EverythingViewModel by viewModels()
    private val adapter = EverythingAdapter()

    override fun initialize() {
        setupRecyclerView()
    }

    override fun setupSubscribes() {
        subscribesEverything()
    }

    private fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
    }

    private fun subscribesEverything() {
        viewModel.fetchEverything().observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Error -> {
                    Timber.e(it.message.toString())
                }
                is Resource.Loading -> {}
                is Resource.Success -> {
                    adapter.submitList(it.data!!.articles)
                }
                else -> {}
            }
        }
    }
}