package com.example.news_app.api_data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class retro_Instance {
    companion object{
        val baseUrl = "https://newsapi.org/v2/"

        fun getRetrofitInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}