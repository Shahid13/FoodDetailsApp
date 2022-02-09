package com.example.mvvm_room_retrofit_kotlin.recyclerview

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.fooddetailsapp.databinding.ListItemBinding
import com.example.fooddetailsapp.model.Response

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.DataListHoder>() {
    private var foodList: List<Response> = ArrayList()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListHoder {
        val itemView=ListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return DataListHoder(itemView)
    }

    override fun onBindViewHolder(holder: DataListHoder, position: Int) {

        holder.foodTitle.text=foodList[position].title
        holder.foodCalories.text= "Calories "+ foodList[position].calories.toString() +"%"
        holder.foodCarbs.text= "Carbs "+ foodList[position].carbs.toString() +"%"
        holder.foodProtein.text= "Protein "+ foodList[position].protein.toString() +"%"
        holder.foodFat.text= "Fat "+ foodList[position].fat.toString() +"%"
        holder.foodFiber.text= "Fiber "+ foodList[position].fiber.toString() +"%"
        holder.foodSaturatedfat.text= "Saturatedfat "+  foodList[position].saturatedfat.toString() +"%"
        holder.foodUnsaturatedfat.text="Unsaturatedfat " + foodList[position].unsaturatedfat.toString() +"%"
        holder.foodtvCholesterol.text="Cholesterol " + foodList[position].cholesterol.toString() +"%"
    }

    override fun getItemCount(): Int {
        return foodList.size
    }

    fun setNotes(foodItem: List<Response>) {
        foodList = ArrayList()
        this.foodList = foodItem
        notifyDataSetChanged()
    }


    inner class DataListHoder(itemView:  ListItemBinding) :RecyclerView.ViewHolder(itemView.root){
            val foodTitle   = itemView.tvTitle
            val foodCarbs   = itemView.tvCarbs
            val foodProtein = itemView.tvProtein
            val foodCalories = itemView.tvCalories
            val foodtvCholesterol   = itemView.tvCholesterol
            val foodFat    = itemView.tvFat
            val foodFiber   = itemView.tvFiber
            val foodSaturatedfat   = itemView.tvSaturatedfat
             val foodUnsaturatedfat  = itemView.tvUnsaturatedfat



    }


}


