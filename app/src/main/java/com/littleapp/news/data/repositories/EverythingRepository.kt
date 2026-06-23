package com.littleapp.news.data.repositories

import com.littleapp.news.base.BaseRepository
import com.littleapp.news.data.remote.NewsApiServices
import javax.inject.Inject

class EverythingRepository @Inject constructor(private val service: NewsApiServices) :
    BaseRepository() {

    fun fetchEverything() = doRequest {
        service.fetchEverything("bitcoin")
    }

    fun fetchTopArticles() = doRequest {
        service.fetchTopArticles("us")
    }
}