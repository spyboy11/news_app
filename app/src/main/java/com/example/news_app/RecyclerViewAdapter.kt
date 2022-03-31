package com.example.news_app

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.news_app.api_data.DiffUtil
import com.example.news_app.api_data.apiData

class RecyclerViewAdapter: PagedListAdapter<apiData, RecyclerViewAdapter.ViewHolder>(DiffUtil()) {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        /*
        val source: String,
        val id: String,
        val name: String,-
        val author: String,-
        val title: String,-
        val discription: String,-
        val url: String,-
        val urlToImage: String,-
        val publishedAt: String,-
        val content: String-
         */
        val newsImg: ImageView = view.findViewById(R.id.newsImg)
        val author: TextView = view.findViewById(R.id.author)
        val date: TextView = view.findViewById(R.id.date)
        val title: TextView = view.findViewById(R.id.title)
        val description: TextView = view.findViewById(R.id.description)
        val siteUrl: TextView = view.findViewById(R.id.url)
        val content: TextView = view.findViewById(R.id.content)

        fun bind(data: apiData){
            author.text = data.author
            date.text = data.publishedAt
            title.text = data.title
            description.text = data.discription
            siteUrl.text = data.url
            content.text = data.content

            val url = data.urlToImage

            Glide.with(newsImg)
                .load(url)
                .circleCrop()
                .into(newsImg)
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        TODO("Not yet implemented")
    }
}