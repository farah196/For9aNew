package com.example.farahal_kiswani.demo

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import android.support.annotation.NonNull
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import java.io.IOException


class ApiClient1 {


    companion object {

        val BASE_URL = "https://api.for9a.com/"

        var retofit: Retrofit? = null

        val client: Retrofit
            get() {
                OkHttpClient.Builder().addInterceptor { chain ->
                    val newRequest = chain.request().newBuilder()
                            .addHeader("authentication","MNrAG2QLv41sWs2qd-spRKT594bfwROM")

                            .build()
                    chain.proceed(newRequest)
                }.build()
                if (retofit == null) {
                    retofit = Retrofit.Builder()
                            .baseUrl(BASE_URL)

                            .addConverterFactory(GsonConverterFactory.create())
                            .build()
                }
                return retofit!!
            }
    }
}