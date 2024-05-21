package com.berkanteruysal.fakeapiproject.service

import com.berkanteruysal.fakeapiproject.model.Shop
import retrofit2.Call
import retrofit2.http.GET

interface ShopAPI {
    @GET("products")
    fun getCountries(): Call<List<Shop>>
}