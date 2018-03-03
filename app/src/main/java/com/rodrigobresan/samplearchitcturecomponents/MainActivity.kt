package com.rodrigobresan.samplearchitcturecomponents

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.lifecycle.LifecycleSampleActivity
import com.rodrigobresan.samplearchitcturecomponents.viewmodel.ViewModelActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        btn_main_lifecycle.setOnClickListener { openActivity(LifecycleSampleActivity.provideIntent(this)) }
        btn_main_viewmodel.setOnClickListener { openActivity(ViewModelActivity.provideIntent(this)) }
    }

    private fun openActivity(intent: Intent) {
        startActivity(intent)
    }
}