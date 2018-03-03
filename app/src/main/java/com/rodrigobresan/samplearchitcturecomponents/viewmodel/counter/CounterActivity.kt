package com.rodrigobresan.samplearchitcturecomponents.viewmodel.counter

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_view_model.*

class CounterActivity : AppCompatActivity() {


    companion object {
        fun provideIntent(context: Context) : Intent {
            val intent = Intent(context, CounterActivity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_view_model)

        // special note: never ever pass context or view references to the view model class, since
        // doing it will result in memory leaks and/or crashes and also defeat completely the purpose
        // of it
        val counterViewModel = ViewModelProviders.of(this).get(CounterViewModel::class.java)

        txt_view_model_count.text = counterViewModel.counter.toString()

        btn_view_model_increase.setOnClickListener {
            counterViewModel.counter++
            txt_view_model_count.text = counterViewModel.counter.toString()
        }
    }
}