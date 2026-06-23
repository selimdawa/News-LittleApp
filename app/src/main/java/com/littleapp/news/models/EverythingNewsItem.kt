package com.littleapp.news.models

import com.google.gson.annotations.SerializedName
import com.littleapp.news.base.IBaseDiffModel

data class EverythingNewsItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val tittle: String,
) : IBaseDiffModel<Int>