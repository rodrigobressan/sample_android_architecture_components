package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import kotlin.repeat

class NewsRepository {

    companion object {
        fun getArticles(): ArrayList<NewsArticle> {

            var articleList = arrayListOf<NewsArticle>()

            repeat(10) {
                val article = NewsArticle("Article " + it, "Description for article " + it)
                articleList.add(article)
            }

            return articleList
        }

    }
}