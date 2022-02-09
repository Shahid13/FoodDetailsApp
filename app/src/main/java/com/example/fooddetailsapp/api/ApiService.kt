package com.example.fooddetailsapp.api

import com.example.fooddetailsapp.model.ApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiService {



    @GET("/v2/foodipedia/codetest")
    suspend fun getApiResponse(@Header("Authorization") apiKey:String, @Query("foodid") foodId:Int): Response<ApiResponse>




}