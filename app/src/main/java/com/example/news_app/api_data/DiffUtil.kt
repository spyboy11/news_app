package com.example.news_app.api_data

import androidx.recyclerview.widget.DiffUtil


class DiffUtil: DiffUtil.ItemCallback<apiData>() {
    override fun areItemsTheSame(oldItem: apiData, newItem: apiData): Boolean {
        return oldItem.author == newItem.author
    }

    override fun areContentsTheSame(oldItem: apiData, newItem: apiData): Boolean {
        return oldItem.author == newItem.author && oldItem.publishedAt == newItem.publishedAt
    }
}