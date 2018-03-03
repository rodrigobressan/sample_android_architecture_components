package com.rodrigobresan.samplearchitcturecomponents.android_viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.content.Context
import android.net.wifi.WifiManager

class WifiViewModel(application: Application) : AndroidViewModel(application) {

    private var wifiManager: WifiManager = application.getSystemService(Context.WIFI_SERVICE) as WifiManager

    fun getConfiguredNetworks() = wifiManager.configuredNetworks
}