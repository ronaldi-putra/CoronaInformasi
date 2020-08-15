package com.ronaldiputra.coronainformasi.api

import com.ronaldiputra.coronainformasi.model.DetailResponse
import com.ronaldiputra.coronainformasi.model.IndonesiaResponse
import com.ronaldiputra.coronainformasi.model.ProvinsiResponse
import retrofit2.Call
import retrofit2.http.GET

interface IndonesiaAPI {

    @GET("update.json")
    fun getUpdate(): Call<IndonesiaResponse>

    @GET("update.json")
    fun getDetail(): Call<DetailResponse>

    @GET("prov.json")
    fun getProv(): Call<ArrayList<ProvinsiResponse>>

}