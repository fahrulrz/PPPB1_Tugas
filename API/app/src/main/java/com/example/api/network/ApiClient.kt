package com.example.api.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getInstance():ApiService {
        val mHttpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BODY)


//        val mOkHttpClient = okhttp3.OkHttpClient.Builder()
//            .addInterceptor(mHttpLoggingInterceptor)
//            .build()


        val mOkHttpClient = OkHttpClient.Builder()
            .addInterceptor(mHttpLoggingInterceptor)
            .build()

        val builder = Retrofit.Builder()
            .baseUrl("https://reqres.in/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()

        return builder.create(ApiService::class.java)

    }
}