package com.example.techbullassignment.api

import com.example.techbullassignment.model.Root
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET(".")
    fun getAllMovieList(@Query("s") movieName: String, @Query("apikey") apiKey: String): Call<Root>
}