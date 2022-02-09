package com.example.fooddetailsapp.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.fooddetailsapp.model.ApiResponse
import com.example.fooddetailsapp.model.Response


@Dao
interface FoodDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToDataBase(foodCodesResponse: Response)

    @Query("SELECT * FROM food")
    suspend fun getFromDataBase():List<Response>
}