package com.example.tmdbmovieapp.network

import com.example.tmdbmovieapp.methods.ApiMethods
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Retrofit {
     private val Retrofitclient: Retrofit.Builder by lazy {
         Retrofit.Builder().baseUrl("https://api.themoviedb.org")
             .addConverterFactory(GsonConverterFactory.create(Gson()))
     }

    val ApiCall: ApiMethods by lazy {
        Retrofitclient.build().create(ApiMethods::class.java)
    }
 }