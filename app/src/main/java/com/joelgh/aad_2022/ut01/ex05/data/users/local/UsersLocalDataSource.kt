package com.joelgh.aad_2022.ut01.ex05.data.users.local

import android.app.Activity
import android.content.Context
import com.google.gson.Gson
import com.joelgh.aad_2022.ut01.ex03.domain.News
import com.joelgh.aad_2022.ut01.ex05.domain.User

class UsersLocalDataSource (val activity: Activity){

    val sharedPref = activity.getPreferences(Context.MODE_PRIVATE)
    val gson = Gson()
    val editor = sharedPref.edit()

    fun saveUsers(users: List<User>){

        users.forEach {
            editor.putString(it.id.toString(), gson.toJson(it))
            editor.apply()
        }
    }

    fun getUsers()= sharedPref.all.map{entry ->
            gson.fromJson(entry.value as String, User::class.java)
        }.toMutableList()

    fun findById(userId: Int): User?{

        val jsonString = sharedPref.getString(userId.toString(), null)

        return if(jsonString != null) {
            gson.fromJson(jsonString, User::class.java)
        }else{
            null
        }
    }

    fun deleteUser(userId: Int){
        var usersList = this.getUsers()

        usersList.remove(findById(userId))

        editor.clear()
        saveUsers(usersList)
    }
}