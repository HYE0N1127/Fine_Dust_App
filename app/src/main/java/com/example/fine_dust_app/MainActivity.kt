package com.example.fine_dust_app

import android.app.Activity
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.fine_dust_app.data.model.GithubInfo
import com.example.fine_dust_app.data.retrofit_builder.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var tvBio: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvBio = findViewById(R.id.tvBio)
        val profileImage: ImageView = findViewById(R.id.ivProfile)

        val call = RetrofitBuilder().githubApi.getGithubInfo()

        call.enqueue(object : Callback<GithubInfo> {
            override fun onResponse(call: Call<GithubInfo>, response: Response<GithubInfo>) {
                val userInfo = response.body()

                Log.d(
                    "response",
                    "${userInfo?.bio} ${userInfo?.login} ${userInfo?.followers} ${userInfo?.following} ${userInfo?.html_url} ${userInfo?.name}" +
                            "${userInfo?.company} ${userInfo?.location} ${userInfo?.blog} ${userInfo?.avatar_url}"
                )
                tvBio.text = userInfo?.bio.toString()
            }

            override fun onFailure(call: Call<GithubInfo>, t: Throwable) {
                Log.d("error", t.message.toString())
            }

            fun getImageURL(imageURL: String) {

                Glide.with(Activity())
                    .load(imageURL)
                    .into(profileImage)

            }
        })
    }
}


