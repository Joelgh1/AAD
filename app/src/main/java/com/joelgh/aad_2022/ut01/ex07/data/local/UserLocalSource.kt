package com.joelgh.aad_2022.ut01.ex07.data.local

import android.app.Activity
import android.content.Context
import com.google.gson.Gson
import com.joelgh.aad_2022.ut01.ex07.domain.User

class UserLocalSource(private val activity: Activity) {
    private val sharedPrefs = activity.getPreferences(Context.MODE_PRIVATE)
    private val editor = sharedPrefs.edit()
    private val gson = Gson()

    //Create
    fun saveUser(user: User){
        user.id = user.name + user.phone
        editor.putString(user.id.toString(), gson.toJson(user))
        editor.apply()
    }

    fun saveUsers(userList: List<User>){
        userList.forEach {
            saveUser(it)
        }
    }

    //Read
    fun getUsers() = sharedPrefs.all.map { entry ->
            gson.fromJson(entry.value as String, User::class.java)
        }

    fun getUser(userId: String) =
        gson.fromJson(sharedPrefs.getString(userId.toString(), null), User::class.java)

    //Update
    fun updateUser(user: User){
        saveUser(user)
    }

    //Delete
    fun deleteUser(userId: String){
        val users = getUsers().toMutableList()
        users.remove(getUser(userId))
        editor.clear()
        saveUsers(users)
    }
}