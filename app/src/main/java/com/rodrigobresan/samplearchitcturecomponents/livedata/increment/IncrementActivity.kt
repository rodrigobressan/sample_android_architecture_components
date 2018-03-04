package com.rodrigobresan.samplearchitcturecomponents.viewmodel.counter

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.R
import com.rodrigobresan.samplearchitcturecomponents.livedata.IncrementViewModel
import kotlinx.android.synthetic.main.activity_view_model.*

class IncrementActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context) : Intent {
            val intent = Intent(context, IncrementActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_model)

        // special note: never ever pass context or view references to the view model class, since
        // doing it will result in memory leaks and/or crashes and also defeat completely the purpose
        // of it
        val incrementViewModel = ViewModelProviders.of(this).get(IncrementViewModel::class.java)

        incrementViewModel.counter.observe(this, Observer {
            txt_view_model_count.text = it.toString()
        })

        btn_view_model_increase.setOnClickListener {
            incrementViewModel.increment()
        }
    }
}