package com.littleapp.news.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.littleapp.news.databinding.ItemEverythingListBinding
import com.littleapp.news.base.BaseDiffUtilItemCallback
import com.littleapp.news.models.everything.EverythingNewsItem

class EverythingAdapter :
    ListAdapter<EverythingNewsItem, EverythingAdapter.EverythingViewHolder>(BaseDiffUtilItemCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EverythingViewHolder =
        EverythingViewHolder(
            ItemEverythingListBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )

    override fun onBindViewHolder(holder: EverythingViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    class EverythingViewHolder(private val binding: ItemEverythingListBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: EverythingNewsItem) {
            binding.tvTittle.text = model.tittle
        }
    }
}