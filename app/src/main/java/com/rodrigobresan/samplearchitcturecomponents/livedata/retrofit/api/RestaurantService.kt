package com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit.api

import android.arch.lifecycle.LiveData
import com.rodrigobresan.samplearchitcturecomponents.livedata.retrofit.utils.LiveDataCallAdapterFactory
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RestaurantService {

    @GET("restaurants")
    fun getRestaurants(): LiveData<ApiResponse<RestaurantsResponse>>

    companion object Factory {
        private const val BASE_URL = "http://demo0080297.mockable.io/"

        fun getRestaurantService(): RestaurantService {
            return Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(LiveDataCallAdapterFactory())
                    .build()
                    .create(RestaurantService::class.java)
        }
    }
}