package com.joelgh.aad_2022.ut01.ex05.data.users.remote

import com.joelgh.aad_2022.ut01.ex05.data.users.remote.models.UserApiModel
import com.joelgh.aad_2022.ut01.ex05.domain.Address
import com.joelgh.aad_2022.ut01.ex05.domain.Company
import com.joelgh.aad_2022.ut01.ex05.domain.Geo
import com.joelgh.aad_2022.ut01.ex05.domain.User
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UsersRemoteDataSource {

    private val urlEndPoint = "https://jsonplaceholder.typicode.com/"
    private var apiEndPoints: ApiEndPoints

    init{
        apiEndPoints = buildApiEndPoints()
    }

    private fun buildClient() = Retrofit.Builder()
        .baseUrl(urlEndPoint)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private fun buildApiEndPoints() = buildClient().create(ApiEndPoints::class.java)

    fun getUsers(): MutableList<UserApiModel>{
        val callUsers = apiEndPoints.getUsers() //Llamada
        val response = callUsers.execute()      //Ejecucion de la llamada

        return if(response.isSuccessful){
            val users = response.body()
            users ?: emptyList()
        }else{
            emptyList()
        }.toMutableList()
    }

    fun getUser(userId: Int): UserApiModel?{
        val response = apiEndPoints.getUser(userId).execute()

        return if(response.isSuccessful){
            response.body()
        }else{
            null
        }
    }
}