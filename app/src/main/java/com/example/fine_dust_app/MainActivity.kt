package com.example.fine_dust_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fine_dust_app.data.model.FineDustInfo
import com.example.fine_dust_app.data.retrofit_builder.RetrofitBuilder
import retrofit2.Call
import retrofit2.Response
import retrofit2.adapter.rxjava2.Result.response
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        RetrofitBuilder.api.getFineDustInfo(
            "SGJqVHt%2BqeGLUxZa8LDlLQOckhkBdWawZ6rAqmC%2FwvCQRGIrkg9ZLJv%2Fya4iVfhFbSFdhg9cQgcsG4e0HY4LAQ%3D%3D",
            "DAILY", "json", "유가읍"
        )
            .enqueue(object : retrofit2.Callback<FineDustInfo> {
                override fun onResponse(
                    call: Call<FineDustInfo>,
                    response: Response<FineDustInfo>
                ) {
                    var fineDustInfo = response.headers()
                    Log.d(
                        "response",
                        response.body()?.response?.body?.items?.get(1)?.no2Grade.toString())
                }

                override fun onFailure(call: Call<FineDustInfo>, t: Throwable) {
                    Log.d("error", t.message.toString())
                }
            })
    }
}