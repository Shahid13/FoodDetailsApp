package com.example.fooddetailsapp.api

import com.example.fooddetailsapp.utils.NetworkUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//object keyword use to make single object of RetrofitClass

object RetrofitApiService {

    private var retrofit: Retrofit? = null

    fun getInstance():Retrofit{

        if (retrofit==null) {

               retrofit= Retrofit.Builder().baseUrl(NetworkUtils.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()


        }



        return retrofit!!
    }




}