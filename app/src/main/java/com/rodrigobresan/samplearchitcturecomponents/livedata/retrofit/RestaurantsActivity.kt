package com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.rodrigobresan.samplearchitcturecomponents.R
import kotlinx.android.synthetic.main.activity_restaurants.*

class RestaurantsActivity : AppCompatActivity() {

    companion object {
        fun provideIntent(context: Context): Intent {
            val intent = Intent(context, RestaurantsActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_restaurants)

        val restaurantAdapter = RestaurantAdapter()
        rv_restaurants.layoutManager = LinearLayoutManager(this)
        rv_restaurants.adapter = restaurantAdapter

        val restaurantViewModel = ViewModelProviders.of(this).get(RestaurantViewModel::class.java)

        restaurantViewModel.getRestaurants().observe(this, Observer {
            it?.body?.restaurants.let {
                restaurantAdapter.swapRestaurants(it!!)
            }
        })
    }
}