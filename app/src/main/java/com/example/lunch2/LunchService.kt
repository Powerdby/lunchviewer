package com.example.lunch2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface LunchService {
    @GET("mealServiceDietInfo")
    fun getLunchData(@Query("KEY") KEY: String,
                      @Query("Type") Type: String): Call<lunch>
}
