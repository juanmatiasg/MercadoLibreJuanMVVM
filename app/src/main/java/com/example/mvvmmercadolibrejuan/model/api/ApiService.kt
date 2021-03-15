package com.example.mvvmmercadolibrejuan.model.api

import com.example.mvvmmercadolibrejuan.model.BaseProductos
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("sites/MLA/search?q=")  /*Se busca todos los productos*/
    suspend fun search(@Query("q") q: String): BaseProductos
}