package com.rodrigobresan.samplearchitcturecomponents.lifecycle

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.R

class LifecycleSampleActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context) : Intent {
            var intent = Intent(context, LifecycleSampleActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lifecycle)
        lifecycle.addObserver(LifecycleAwareLogging())
        lifecycle.addObserver(MusicObserver(this))
    }
}