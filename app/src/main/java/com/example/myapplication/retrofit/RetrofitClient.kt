package com.example.myapplication.retrofit

import com.example.myapplication.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory




object RetrofitClient {

    fun getClient(): Retrofit {

            return Retrofit.Builder()
                .baseUrl(Constants.URL_API)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

    }

}