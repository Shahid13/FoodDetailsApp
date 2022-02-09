package com.example.mvvm_room_retrofit_kotlin.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fooddetailsapp.model.Response
import com.example.fooddetailsapp.repository.FoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repositoryData: FoodRepository) : ViewModel(){

     init {
           viewModelScope.launch(Dispatchers.IO) {
               repositoryData.getFoodCodes()
           }

     }

   val viewModelFoodCodes:LiveData<List<Response>> = repositoryData._foodCodes

}