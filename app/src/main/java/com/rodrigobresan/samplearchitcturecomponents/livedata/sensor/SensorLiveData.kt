package com.rodrigobresan.samplearchitcturecomponents.livedata.sensor

import android.arch.lifecycle.LiveData
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager

class SensorLiveData(context: Context) : LiveData<Float>(), SensorEventListener {

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onSensorChanged(event: SensorEvent) {
        value = event.values[0]
    }

    private val sensorManager: SensorManager = context.getSystemService(Context.SENSOR_SERVICE) as SensorManager
    private var accelerometerSensor: Sensor

    init {
        accelerometerSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER)
    }

    override fun onActive() {
        super.onActive()
        sensorManager.registerListener(this, accelerometerSensor, SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onInactive() {
        super.onInactive()
        sensorManager.unregisterListener(this)
    }
}