package com.rodrigobresan.samplearchitcturecomponents

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.android_viewmodel.WifiListActivity
import com.rodrigobresan.samplearchitcturecomponents.lifecycle.LifecycleSampleActivity
import com.rodrigobresan.samplearchitcturecomponents.viewmodel.counter.CounterActivity
import com.rodrigobresan.samplearchitcturecomponents.viewmodel.counter.IncrementActivity
import com.rodrigobresan.samplearchitcturecomponents.viewmodel.news.NewsActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btn_main_lifecycle.setOnClickListener { openActivity(LifecycleSampleActivity.provideIntent(this)) }
        btn_main_viewmodel.setOnClickListener { openActivity(NewsActivity.provideIntent(this)) }
        btn_main_android_viewmodel.setOnClickListener { openActivity(WifiListActivity.provideIntent(this)) }
        btn_main_livedata.setOnClickListener { openActivity(IncrementActivity.provideIntent(this)) }
    }

    private fun openActivity(intent: Intent) {
        startActivity(intent)
    }
}