package com.littleapp.news.ui.fragments.everything

import com.littleapp.news.base.BaseViewModel
import com.littleapp.news.data.repositories.EverythingRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class EverythingViewModel @Inject constructor(private val repository: EverythingRepository) :
    BaseViewModel() {

    fun fetchEverything() = repository.fetchEverything()
}