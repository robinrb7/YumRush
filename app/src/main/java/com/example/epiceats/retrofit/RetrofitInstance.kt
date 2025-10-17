package com.example.epiceats.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitInstance {
    private const val BASE_URL = "https://spring-boot-demo-1-s1di.onrender.com/"


    private fun getRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getApiService(): RetrofitInterface {
        return getRetrofitInstance().create(RetrofitInterface::class.java)
    }
}