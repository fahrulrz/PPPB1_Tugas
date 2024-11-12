package com.example.api.network

import com.example.api.model.Users
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getAllUsers(): Call<Users>
}