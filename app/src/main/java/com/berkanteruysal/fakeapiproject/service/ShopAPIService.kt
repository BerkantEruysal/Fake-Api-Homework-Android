package com.berkanteruysal.fakeapiproject.service

import com.berkanteruysal.fakeapiproject.model.Shop
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ShopAPIService {
    private val BASE_URL = "https://fakestoreapi.com/"
    private val api = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ShopAPI::class.java)
    fun getData(): Call<List<Shop>>{
        return api.getCountries()
    }

}