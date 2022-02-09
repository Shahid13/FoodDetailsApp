package com.example.fooddetailsapp.utils

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build

class NetworkUtils {

    //val BASE_URL=https://api.lifesum.com/v2/foodipedia/codetest?foodid=3

companion object{


   const val api_key="23863708:465c0554fd00da006338c72e282e939fe6576a25fd00c776c0fbe898c47c9876"
    const val BASE_URL="https://api.lifesum.com/"

    var randomId:Int =(Math.random() * (200 - 1)).toInt() + 1











    fun isInternetAvailable(context: Context): Boolean {
        (context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).run {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                return this.getNetworkCapabilities(this.activeNetwork)?.hasCapability(
                    NetworkCapabilities.NET_CAPABILITY_INTERNET
                ) ?: false
            } else {
                (@Suppress("DEPRECATION")
                return this.activeNetworkInfo?.isConnected ?: false)
            }
        }
    }

}






}