package com.rodrigobresan.samplearchitcturecomponents.android_viewmodel

import android.net.wifi.WifiConfiguration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rodrigobresan.samplearchitcturecomponents.R

class WifiAdapter : RecyclerView.Adapter<WifiAdapter.WifiViewHolder>() {

    lateinit var wifiList: List<WifiConfiguration>

    fun swapWifis(wifiList: List<WifiConfiguration>) {
        this.wifiList = wifiList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return wifiList.size
    }

    override fun onBindViewHolder(holder: WifiViewHolder, position: Int) {
        val item = wifiList[position]

        holder.txtTitle.text = item.SSID
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WifiViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_wifi, parent, false)
        return WifiViewHolder(view)
    }

    class WifiViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txt_item_wifi_name)
    }

}