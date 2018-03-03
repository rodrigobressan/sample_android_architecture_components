package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rodrigobresan.samplearchitcturecomponents.R

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {

    lateinit var newsList: List<NewsArticle>

    fun swapArticles(newsArticles: ArrayList<NewsArticle>) {
        this.newsList = newsArticles
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = newsList[position]

        holder.txtTitle.text = item.title
        holder.txtDescription.text = item.description
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_article, parent, false)
        return NewsViewHolder(view)
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txt_item_article_title)
        var txtDescription: TextView = itemView.findViewById(R.id.txt_item_article_description)
    }

}