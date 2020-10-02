package com.example.newsapi

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.newsapi.adapter.NewsAdapter
import com.example.newsapi.api.ApiClient
import com.example.newsapi.model.ArticlesItem
import com.example.newsapi.model.News
import com.example.newsapi.viewmodel.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       var homeFragment = ViewModelProvider(this).get(HomeViewModel::class.java)
        var newsAdapter = NewsAdapter()
        newRecycler.layoutManager = LinearLayoutManager(context)
        newRecycler.adapter = newsAdapter
        homeFragment.loadArticle()
        homeFragment.getArticle().observe(viewLifecycleOwner, Observer { news -> newsAdapter.updateArticle(news.articles as List<ArticlesItem>)})

    }
}