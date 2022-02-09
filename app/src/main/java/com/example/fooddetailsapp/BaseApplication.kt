package com.example.fooddetailsapp

import android.app.Application
import com.example.fooddetailsapp.api.ApiService
import com.example.fooddetailsapp.api.RetrofitApiService
import com.example.fooddetailsapp.model.db.FoodDatabase
import com.example.fooddetailsapp.repository.FoodRepository


class BaseApplication: Application() {
 lateinit var foodRepository: FoodRepository
    override fun onCreate() {
        super.onCreate()
        initObject()
    }

    private fun initObject() {
        val quotesService= RetrofitApiService.getInstance().create(ApiService::class.java)
        val database=FoodDatabase.getDatabase(applicationContext)
        foodRepository= FoodRepository(quotesService,database,applicationContext)



    }
}