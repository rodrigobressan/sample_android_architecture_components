package com.rodrigobresan.samplearchitcturecomponents.lifecycle

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.R

class LifecycleSampleActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        lifecycle.addObserver(LifecycleAwareLogging())
        lifecycle.addObserver(MusicObserver(this))
    }
}