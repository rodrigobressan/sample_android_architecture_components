package com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit.api.RestaurantService

class RestaurantViewModel(application: Application) : AndroidViewModel(application) {

    val restaurantRepository by lazy { RestaurantRepository(RestaurantService.getRestaurantService()) }

    fun getRestaurants() = restaurantRepository.getRestaurants()
}