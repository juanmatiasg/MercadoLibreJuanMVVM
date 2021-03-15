package com.example.mvvmmercadolibrejuan.model.api

class ApiHelper(private val apiService: ApiService) {
    suspend fun getListProduct() = apiService.search("Pelota")
}