package com.berkanteruysal.fakeapiproject.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.berkanteruysal.fakeapiproject.model.Shop
import com.berkanteruysal.fakeapiproject.service.ShopAPIService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {

    private val shopAPI = ShopAPIService()

    val shopData = MutableLiveData<List<Shop>>()
    val shopLoad = MutableLiveData<Boolean>()
    val shopError = MutableLiveData<Boolean>()

    fun getDataFromAPI(){
        shopLoad.value = true

        shopAPI.getData().enqueue(object: Callback<List<Shop>>{
            override fun onResponse(call: Call<List<Shop>>, response: Response<List<Shop>>) {
                shopData.value = response.body()
                shopLoad.value = false
                shopError.value = false
            }

            override fun onFailure(call: Call<List<Shop>>, t: Throwable) {
                shopLoad.value = false
                shopError.value = true
                Log.e("RetrofitError",t.message.toString())
            }
        })

    }

}