package com.example.news_app.api_data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface retro_interface {
    @GET("top-headlines?sources=google-news&apiKey=abcc8ef069d74e58a4f8647a83b2e18e")
    abstract fun getDataFromApi(@Query("status")status: String): Call<apiData>
}