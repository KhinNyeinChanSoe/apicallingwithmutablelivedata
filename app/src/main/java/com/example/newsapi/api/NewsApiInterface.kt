package com.example.newsapi.api

import com.example.newsapi.model.News
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
//import java.nio.channels.spi.AbstractSelectionKey

interface NewsApiInterface {
    @GET("everything")
    fun getEverything(
        @Query("q")keyword :String,
        @Query("apiKey")apiKey: String
    ):Call<News>
}