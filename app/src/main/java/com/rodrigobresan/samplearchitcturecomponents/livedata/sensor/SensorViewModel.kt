package com.rodrigobresan.samplearchitcturecomponents.livedata.sensor

import android.app.Application
import android.arch.lifecycle.AndroidViewModel

class SensorViewModel(application: Application) : AndroidViewModel(application) {

    private var sensorLiveData = SensorLiveData(application)

    fun getSensorData() = sensorLiveData
}