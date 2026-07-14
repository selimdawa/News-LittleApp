package com.littleapp.news.data.remote

import com.littleapp.news.models.EverythingNewsItem
import com.littleapp.news.models.NewsResponse
import com.littleapp.news.models.TopArticlesNewsItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApiServices {

    @GET("everything")
    suspend fun fetchEverything(
        @Query("q") query: String
    ): Response<NewsResponse<EverythingNewsItem>>

    @GET("top-headlines")
    suspend fun fetchTopArticles(
        @Query("country") country: String
    ): Response<NewsResponse<TopArticlesNewsItem>>
}