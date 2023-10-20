package com.example.tmdbmovieapp.datamodels

import com.google.gson.annotations.SerializedName

data class MoviesResult(
    @SerializedName("original_title")
    var title:String,
    @SerializedName("original_language")
    var language:String,
    @SerializedName("overview")
    var overview:String,
    @SerializedName("popularity")
    var popularity:Double,
    @SerializedName("poster_path")
    var poster:String,
    @SerializedName("release_date")
    var releseDate:String,
    @SerializedName("adult")
    var adults:Boolean
)
