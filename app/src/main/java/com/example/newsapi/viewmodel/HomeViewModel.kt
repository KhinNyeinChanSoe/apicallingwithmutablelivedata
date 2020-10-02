package com.example.newsapi.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.newsapi.api.ApiClient
import com.example.newsapi.model.ArticlesItem
import com.example.newsapi.model.News
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeViewModel: ViewModel() {
    private var news:MutableLiveData<News> = MutableLiveData()
        fun getArticle(): MutableLiveData<News> = news
        fun loadArticle(){
            var apiClient = ApiClient()
            var apiCall = apiClient.getEverything()
            apiCall.enqueue(object : Callback<News> {
                override fun onResponse(call: Call<News>, response: Response<News>) {
                    news.value = response.body()
                }

                override fun onFailure(call: Call<News>, t: Throwable) {
                    Log.d("ErrorMsg>>>>>>",t.toString())

                }


            })

    }
}