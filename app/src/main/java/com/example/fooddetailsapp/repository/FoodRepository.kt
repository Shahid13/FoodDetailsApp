package com.example.fooddetailsapp.repository

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fooddetailsapp.api.ApiService
import com.example.fooddetailsapp.model.ApiResponse
import com.example.fooddetailsapp.model.Response
import com.example.fooddetailsapp.model.db.FoodDatabase
import com.example.fooddetailsapp.utils.NetworkUtils
import kotlin.random.Random
class FoodRepository(private val apiService: ApiService,
                     private val foodDatabase: FoodDatabase,
                     private val applicationContext:Context) {

    private val foodCodes= MutableLiveData <List<Response>>()
    val _foodCodes:LiveData<List<Response>> get() = foodCodes
    //here  api call,this fun call by viewModel to get data
    suspend fun getFoodCodes(){

        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val randomId:Int = Random.nextInt(1,200)
            val result=apiService.getApiResponse(apiKey =NetworkUtils.api_key ,foodId=randomId)
            if (result.body() != null)
            {
                foodDatabase.FoodCodesDao().addToDataBase(result.body()!!.response)
                foodCodes.postValue(listOf(result.body()!!.response)) }
            }
        else
        {

            val foodCodeList=foodDatabase.FoodCodesDao().getFromDataBase()
                foodCodes.postValue(foodCodeList)
        }




    }


}


