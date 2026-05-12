package com.littleapp.news.models.toparticles

import com.littleapp.news.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class TopArticlesNewsItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val tittle: String,
    @SerializedName("urlToImage")
    val image: String,
) : IBaseDiffModel<Int>
