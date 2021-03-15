package com.example.mvvmmercadolibrejuan.model.repository

import com.example.mvvmmercadolibrejuan.model.api.ApiHelper

class Repo(private val apiHelper: ApiHelper) {
    suspend fun getListProduct() = apiHelper.getListProduct()
}