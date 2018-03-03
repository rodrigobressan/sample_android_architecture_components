package com.rodrigobresan.samplearchitcturecomponents.viewmodel.news

import android.arch.lifecycle.ViewModel

class NewsViewModel : ViewModel() {

    fun getNewsArticles() = NewsRepository.getArticles()
}