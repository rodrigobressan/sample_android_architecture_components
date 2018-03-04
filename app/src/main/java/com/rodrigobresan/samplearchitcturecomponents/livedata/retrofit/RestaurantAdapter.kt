package com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit

import android.net.wifi.WifiConfiguration
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rodrigobresan.samplearchitcturecomponents.R

class RestaurantAdapter : RecyclerView.Adapter<RestaurantAdapter.RestaurantHolder>() {

    var restaurantList: List<RestaurantItem> = arrayListOf()

    fun swapRestaurants(restaurants: List<RestaurantItem>) {
        this.restaurantList = restaurants
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    override fun onBindViewHolder(holder: RestaurantHolder, position: Int) {
        val item = restaurantList[position]

        holder.txtTitle.text = item.name
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestaurantHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_restaurant, parent, false)
        return RestaurantHolder(view)
    }

    class RestaurantHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtTitle: TextView = itemView.findViewById(R.id.txt_item_restaurant_name)
    }

}
