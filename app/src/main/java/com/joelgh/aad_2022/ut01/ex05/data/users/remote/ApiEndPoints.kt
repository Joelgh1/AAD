package com.joelgh.aad_2022.ut01.ex05.data.users.remote

import com.joelgh.aad_2022.ut01.ex05.data.users.remote.models.UserApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiEndPoints {
    @GET("users")
    fun getUsers(): Call<List<UserApiModel>>

    @GET("users/{id}")
    fun getUser(@Path("id") userid: Int): Call<UserApiModel>
}