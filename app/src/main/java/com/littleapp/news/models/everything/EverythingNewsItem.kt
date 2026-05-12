package com.littleapp.news.models.everything

import com.littleapp.news.base.IBaseDiffModel
import com.google.gson.annotations.SerializedName

data class EverythingNewsItem(
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val tittle: String,
) : IBaseDiffModel<Int>
