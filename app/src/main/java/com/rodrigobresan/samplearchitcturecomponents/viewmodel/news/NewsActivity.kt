package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_news.*

class NewsActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context): Intent {
            var intent = Intent(context, FeedActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_news)

        val adapter = NewsAdapter()
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = adapter

        val newsViewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        adapter.swapArticles(newsViewModel.getNewsArticles())
    }
}