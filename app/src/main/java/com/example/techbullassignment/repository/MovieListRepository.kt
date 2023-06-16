package com.example.techbullassignment.repository

import com.example.techbullassignment.api.RetrofitServices
import com.example.techbullassignment.model.Root
import retrofit2.Response

object MovieListRepository {

    fun getMovieList(movieName: String,apiKey:String): Response<Root> {
        return RetrofitServices.api.getAllMovieList(movieName,apiKey).execute()
    }

}