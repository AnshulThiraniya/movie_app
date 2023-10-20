package com.example.tmdbmovieapp.methods

import com.example.tmdbmovieapp.datamodels.ApiData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiMethods {
    @GET("/3/movie/popular")
    fun getmovies(@Query("api_key") apikey:String): Call<ApiData>
}