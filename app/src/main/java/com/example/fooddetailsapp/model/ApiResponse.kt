package com.example.fooddetailsapp.model


import com.google.gson.annotations.SerializedName

data class ApiResponse(
    @SerializedName("meta")
    val meta: Meta,
    @SerializedName("response")
    val response:Response
)