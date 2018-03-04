package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import kotlin.repeat

class FeedRepository {

    companion object {
        fun getArticles(): ArrayList<FeedItem> {

            var articleList = arrayListOf<FeedItem>()

            repeat(10) {
                val article = FeedItem("Article " + it,
                        "Description for article " + it)
                articleList.add(article)
            }

            return articleList
        }

        fun getAnotherArticles(): ArrayList<FeedItem> {

            var articleList = arrayListOf<FeedItem>()

            repeat(10) {
                val article = FeedItem("Another Article " + it,
                        "Description for another article " + it)
                articleList.add(article)
            }

            return articleList
        }

    }
}