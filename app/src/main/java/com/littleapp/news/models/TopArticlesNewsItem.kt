package com.littleapp.news.models

import com.google.gson.annotations.SerializedName
import com.littleapp.news.base.IBaseDiffModel

data class TopArticlesNewsItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val tittle: String,
    @SerializedName("urlToImage")
    val image: String,
) : IBaseDiffModel<Int>