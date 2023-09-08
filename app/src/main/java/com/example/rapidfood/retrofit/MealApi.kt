package com.example.rapidfood.retrofit

import com.example.rapidfood.dataclasses.MealList
import retrofit2.Call
import retrofit2.http.GET

interface MealApi {
   @GET("random.php")
    fun getRandomMeal():Call<MealList>
}