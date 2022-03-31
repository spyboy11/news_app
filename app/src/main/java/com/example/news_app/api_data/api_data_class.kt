package com.example.news_app.api_data

class api_data_class (
    val status: String,
    val articals: ArrayList<apiData>
)

class apiData (
    val source: String,
    val id: String,
    val name: String,
    val author: String,
    val title: String,
    val discription: String,
    val publishedAt: String
)