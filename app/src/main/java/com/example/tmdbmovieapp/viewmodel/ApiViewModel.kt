package com.example.tmdbmovieapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.tmdbmovieapp.datamodels.ApiData
import com.example.tmdbmovieapp.repository.MovieRepository

class ApiViewModel:ViewModel() {

    var movieRepo=MovieRepository()
    var mvloding:MutableLiveData<Boolean> = movieRepo.resloding

    fun getmovie():LiveData<ApiData>{
        return movieRepo.GetResponse()
    }
}