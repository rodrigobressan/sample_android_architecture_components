package com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit.api

import com.google.gson.annotations.SerializedName
import com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit.RestaurantItem

data class RestaurantsResponse(
        @SerializedName("restaurants") var restaurants: List<RestaurantItem> = emptyList()
)