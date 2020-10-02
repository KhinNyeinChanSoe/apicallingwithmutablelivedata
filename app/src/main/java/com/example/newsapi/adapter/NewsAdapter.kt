package com.example.newsapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.newsapi.R
import com.example.newsapi.model.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_news.view.*
import java.lang.reflect.Array.get

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    //adding data with function
    private var articlesItem : List<ArticlesItem> = ArrayList()
    inner class NewsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        //article itemထဲ
        fun bind(articlesItem: ArticlesItem){
            itemView.txtTitle.text = articlesItem.title
            itemView.txtDescription.text = articlesItem.description
//            itemView.newsImage.setImageResource(articlesItem.)
            Picasso.get().load(articlesItem.urlToImage).into(itemView.newsImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_news,parent,false)
        return NewsViewHolder(view)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(articlesItem[position])
    }

    override fun getItemCount(): Int = articlesItem.size

    fun updateArticle(articlesItem: List<ArticlesItem>){
        this.articlesItem = articlesItem
        notifyDataSetChanged()
    }
}