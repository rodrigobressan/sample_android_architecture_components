package com.rodrigobresan.samplearchitcturecomponents.livedata.sensor

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_sensor.*

class SensorActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context) : Intent {
            val intent = Intent(context, SensorActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_sensor)

        val sensorViewModel = ViewModelProviders.of(this).get(SensorViewModel::class.java)

        sensorViewModel.getSensorData().observe(this, Observer {
            txt_sensor_value.text = it.toString()
        })
    }
}