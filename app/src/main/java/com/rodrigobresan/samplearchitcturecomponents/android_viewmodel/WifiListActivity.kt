package com.rodrigobresan.samplearchitcturecomponents.android_viewmodel

import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_wifi.*

class WifiListActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context): Intent {
            var intent = Intent(context, WifiListActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_wifi)

        val wifiAdapter = WifiAdapter()
        rv_wifi.layoutManager = LinearLayoutManager(this)
        rv_wifi.adapter = wifiAdapter

        val wifiViewModel = ViewModelProviders.of(this).get(WifiViewModel::class.java)
        wifiAdapter.swapWifis(wifiViewModel.getConfiguredNetworks())
    }
}