package com.example.newsapi.api

import com.example.newsapi.model.News
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    private  val BASE_URL = "http://newsapi.org/v2/"
    val apiInterface:NewsApiInterface
    init {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        apiInterface = retrofit.create(
            NewsApiInterface::class.java
        )
    }
    fun getEverything():Call<News>{
        return  apiInterface.getEverything("bitcoin","8a8b7906835642d5aa9132c0977ece68")
    }
}