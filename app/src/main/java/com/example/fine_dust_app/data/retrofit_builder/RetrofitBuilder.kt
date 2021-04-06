package com.example.fine_dust_app.data.retrofit_builder

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    var api : fineDustAPI

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://apis.data.go.kr/B552584/ArpltnStatsSvc")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


        api = retrofit.create(fineDustAPI::class.java)
    }

}