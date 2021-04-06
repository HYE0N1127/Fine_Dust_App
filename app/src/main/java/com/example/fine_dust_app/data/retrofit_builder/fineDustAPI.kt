package com.example.fine_dust_app.data.retrofit_builder

import com.example.fine_dust_app.data.model.FineDustInfo
import com.example.fine_dust_app.data.model.Item
import com.example.fine_dust_app.data.model.Response
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Query

interface fineDustAPI {
    @GET(".")
    fun getFineDustInfo(@Query("serviceKey")serviceKey: String, @Query("dataTerm")dataTerm: String,
                        @Query("returnType")returnType: String, @Query("stationName")stationName: String): Call<FineDustInfo>
}