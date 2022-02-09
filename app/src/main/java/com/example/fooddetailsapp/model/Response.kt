package com.example.fooddetailsapp.model


import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "food",indices = [Index(value = ["title"], unique = true)])
data class Response(
    @PrimaryKey(autoGenerate = true)
    val foodId: Int=1,

    val title: String, // 4.5

    val calories: Int,

    val carbs: Double, // 61

    val cholesterol: Double, // 4.8

    val fat: Double, // 0.01

    val fiber: Double, // 3.25

    val gramsperserving: Int, // 0

    val pcstext: String, // 240

    val potassium: Double, // Glass

    val protein: Double, // 0.143

    val saturatedfat: Double, // 3.22

    val sodium: Double, // 1.865

    val sugar: Double, // 0.04

    val unsaturatedfat: Double // 1.007){}
)