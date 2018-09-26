package com.example.farahal_kiswani.demo.util

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {

        val BASE_URL = "https://api.for9a.com/"

        var retofit: Retrofit? = null

        val client: Retrofit
            get() {

                    OkHttpClient.Builder().addInterceptor { chain ->
                        val newRequest = chain.request().newBuilder()
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