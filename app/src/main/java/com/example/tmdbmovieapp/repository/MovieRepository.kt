package com.example.tmdbmovieapp.repository

import androidx.lifecycle.MutableLiveData
import com.example.tmdbmovieapp.datamodels.ApiData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MovieRepository {
    val liveResponse: MutableLiveData<ApiData> = MutableLiveData<ApiData>()
    var resloding: MutableLiveData<Boolean> = MutableLiveData<Boolean>().apply {
        value=true
    }
    fun GetResponse(): MutableLiveData<ApiData> {

        val call= com.example.tmdbmovieapp.network.Retrofit.ApiCall.getmovies("01f4844c24147b7af0e11f948d2e58be")
        call.enqueue(object : Callback<ApiData> {
            override fun onResponse(call: Call<ApiData>, response: Response<ApiData>) {
                if(response.isSuccessful){
                    resloding.value=false
                    liveResponse.value=response.body()
                }
            }
            override fun onFailure(call: Call<ApiData>, t: Throwable) {
                resloding.value=false
            }

        })

        return liveResponse
    }
}