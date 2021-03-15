package com.example.mvvmmercadolibrejuan.model.retrofit

import com.example.mvvmmercadolibrejuan.model.api.ApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object Api {
    private fun getRetrofit():Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.mercadolibre.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiService = getRetrofit().create(ApiService::class.java)
}