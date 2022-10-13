package com.joelgh.aad_2022.ut01.ex07.data

import com.joelgh.aad_2022.ut01.ex07.data.local.UserLocalSource
import com.joelgh.aad_2022.ut01.ex07.data.remote.UserRemoteSource
import com.joelgh.aad_2022.ut01.ex07.domain.User

class UserRepository(val localSource: UserLocalSource, val remoteSource: UserRemoteSource){

    //Create
    fun saveUser(user: User){
        localSource.saveUser(user)
    }

    fun saveUser(users: List<User>){
        localSource.saveUsers(users)
    }

    //Read
    fun getUsers(): List<User>{
        var users = localSource.getUsers()

        if(users.isEmpty()){
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }

        return users
    }

    fun getUser(userId: String) = localSource.getUser(userId)

    //Update
    fun updateUser(user: User){
        localSource.updateUser(user)
    }

    //Delete
    fun deleteUser(userId: String){
        localSource.deleteUser(userId)
    }
}