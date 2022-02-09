package com.example.fooddetailsapp.model.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.fooddetailsapp.model.Response

@Database(entities = [Response::class], version =2, exportSchema = true  )
abstract class FoodDatabase : RoomDatabase() {

    abstract fun FoodCodesDao() : FoodDAO

    companion object{
        @Volatile
        private var INSTANCE: FoodDatabase? = null

        fun getDatabase(context: Context): FoodDatabase {
            if (INSTANCE == null) {
                synchronized(this){
                    INSTANCE = Room.databaseBuilder(context,
                        FoodDatabase::class.java,
                        "foodDB")
                        .build()
                }
            }
            return INSTANCE!!
        }
    }


}