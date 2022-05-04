package com.arka.basicandroidmvvm.api

import com.arka.basicandroidmvvm.models.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("users")
    fun getUsers(): Call<MutableList<User>>

}