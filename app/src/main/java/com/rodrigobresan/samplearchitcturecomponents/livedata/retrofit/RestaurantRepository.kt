package com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit

import com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit.api.RestaurantService

class RestaurantRepository(val restaurantService: RestaurantService) {

    fun getRestaurants() = restaurantService.getRestaurants()
}