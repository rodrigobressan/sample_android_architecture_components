package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class FeedItemViewModel : ViewModel() {

    var itemList: MutableLiveData<List<FeedItem>> = MutableLiveData()

    init {
        itemList.value = FeedRepository.getArticles()
    }

    fun getNewsArticles() = itemList
    fun updateFeed() {
        itemList.value = FeedRepository.getAnotherArticles()
    }
}