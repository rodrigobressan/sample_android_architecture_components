package com.rodrigobresan.samplearchitcturecomponents.livedata

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class IncrementViewModel : ViewModel() {

    var counter: MutableLiveData<Int> = MutableLiveData()

    init {
        counter.value = 0
    }

    fun increment() {
        counter.value = counter.value?.inc()
    }
}