package com.example.fine_dust_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.fine_dust_app.data.model.GithubInfo
import com.example.fine_dust_app.data.retrofit_builder.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val call = RetrofitBuilder().githubApi.getGithubInfo()

        call.enqueue(object : Callback<GithubInfo> {
            override fun onResponse(call: Call<GithubInfo>, response: Response<GithubInfo>) {
                val userInfo = response.body()

                Log.d(
                    "response",
                    "${userInfo?.bio} ${userInfo?.login} ${userInfo?.followers} ${userInfo?.following} ${userInfo?.html_url} ${userInfo?.name}" +
                            "${userInfo?.company} ${userInfo?.location} ${userInfo?.blog}"
                )
            }

            override fun onFailure(call: Call<GithubInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }


        })
    }
}


