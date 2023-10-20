package com.example.tmdbmovieapp.datamodels

import com.google.gson.annotations.SerializedName

data class ApiData(
    @SerializedName("results")
    var movieResult:ArrayList<MoviesResult>
)
