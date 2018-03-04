package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_news.*

class FeedActivity : AppCompatActivity() {

    private val newsViewModel by lazy { ViewModelProviders.of(this).get(FeedItemViewModel::class.java) }

    companion object {
        fun provideIntent(context: Context): Intent {
            var intent = Intent(context, FeedActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_news)

        val adapter = FeedAdapter()
        rv_news.layoutManager = LinearLayoutManager(this)
        rv_news.adapter = adapter

        newsViewModel.getNewsArticles().observe(this, Observer {
            it?.let {
                adapter.swapArticles(it)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.items_feed_activity, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_feed_refresh -> {
                newsViewModel.updateFeed()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}