package com.example.tmdbmovieapp.activity

import android.app.ProgressDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
//import androidx.recyclerview.widget.LinearLayoutManager
import com.example.tmdbmovieapp.Adapter.ResponseAdapter
import com.example.tmdbmovieapp.R
import com.example.tmdbmovieapp.databinding.ActivityMainBinding
import com.example.tmdbmovieapp.viewmodel.ApiViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: ApiViewModel
    lateinit var myAdapter: ResponseAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        viewModel= ViewModelProvider(this)[ApiViewModel::class.java]

        var progressDialog= ProgressDialog(this)
        progressDialog.setMessage("loading please wait...")
        progressDialog.setCancelable(false)

        viewModel.mvloding.observe(this, Observer {
            if(it){
                progressDialog.show()
            }
            else{
                progressDialog.dismiss()
            }
        })

        viewModel.getmovie().observe(this, Observer {
            myAdapter= ResponseAdapter (this,it)
            binding.rvMovie.layoutManager= GridLayoutManager(this,2)
            binding.rvMovie.adapter=myAdapter
            myAdapter.notifyDataSetChanged()
        })

    }
}