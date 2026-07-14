package com.littleapp.news.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.littleapp.news.base.IBaseDiffModel

@Entity(tableName = "top_articles")
data class TopArticlesNewsItem(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    override val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("urlToImage")
    val image: String,
) : IBaseDiffModel<Int>