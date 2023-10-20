package com.example.tmdbmovieapp.Adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tmdbmovieapp.databinding.MovieListFormateBinding
import com.example.tmdbmovieapp.datamodels.ApiData
import com.squareup.picasso.Picasso

class ResponseAdapter(val context: Context, val list: ApiData):
    RecyclerView.Adapter<ResponseAdapter.MyviewHolder>() {

    inner class MyviewHolder(var binding:MovieListFormateBinding): RecyclerView.ViewHolder(binding.root){

    }
    @SuppressLint("SuspiciousIndentation")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyviewHolder {
        var view=MovieListFormateBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyviewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.movieResult.size
    }

    override fun onBindViewHolder(holder: MyviewHolder, position: Int) {
        var product=list.movieResult[position]
       holder.binding.titleMovie.text="Title:- ${product.title}"
        holder.binding.languageMovie.text="Language:- ${product.language}"
        holder.binding.releseDateMovie.text="Relese Date :- ${product.releseDate}"
        holder.binding.adult.text="Adults:- ${product.adults.toString()}"
        holder.binding.overviewMovie.text="Overview:- ${product.overview}"
        holder.binding.populertyMovie.text="Populerity:- ${product.popularity.toString()}"
        Picasso.get().load("https://image.tmdb.org/t/p/w500${product.poster}").into(holder.binding.posterMovie)
    }
}