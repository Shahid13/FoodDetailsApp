package com.example.fooddetailsapp

import android.annotation.SuppressLint
import android.content.Context
import android.hardware.Sensor
import android.hardware.SensorManager
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.core.view.marginTop
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.fooddetailsapp.api.ApiService
import com.example.fooddetailsapp.api.RetrofitApiService
import com.example.fooddetailsapp.databinding.ActivityMainBinding
import com.example.fooddetailsapp.model.Response
import com.example.fooddetailsapp.model.db.FoodDatabase
import com.example.fooddetailsapp.repository.FoodRepository
import com.example.mvvm_room_retrofit_kotlin.recyclerview.RecyclerViewAdapter
import com.example.mvvm_room_retrofit_kotlin.viewmodels.MainViewModel
import com.example.mvvm_room_retrofit_kotlin.viewmodels.MainViewModelFactory
import com.squareup.seismic.ShakeDetector

class MainActivity : AppCompatActivity(), ShakeDetector.Listener {


    lateinit var bindingView: ActivityMainBinding
    var mainViewModel: MainViewModel? =null
     lateinit var sensorManager: SensorManager
    lateinit var accelerometer: Sensor
    lateinit var shakeDetector: ShakeDetector
    val adapter = RecyclerViewAdapter()
    lateinit var recyclerView: RecyclerView




    @SuppressLint("ServiceCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView= ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingView.root)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager
        shakeDetector = ShakeDetector(this)
        shakeDetector.start(sensorManager)
        val recyclerView = bindingView.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter


        val repository = (application as BaseApplication).foodRepository
        mainViewModel= ViewModelProvider(this, MainViewModelFactory(repository)).get(MainViewModel::class.java)


    }

    override fun hearShake() {
        mainViewModel!!.viewModelFoodCodes.observe(this){
            adapter.setNotes(it)
            bindingView.tvTitle.visibility=View.GONE



        }





    }






















}


