package com.joelgh.aad_2022.ut01.ex05.data.users

import com.joelgh.aad_2022.ut01.ex05.data.users.local.UsersLocalDataSource
import com.joelgh.aad_2022.ut01.ex05.data.users.remote.UsersRemoteDataSource
import com.joelgh.aad_2022.ut01.ex05.domain.User

class UserRepository(val localSource: UsersLocalDataSource, val remoteSource: UsersRemoteDataSource) {

    fun getUsers(): List<User>{
        var users = localSource.getUsers()
        if(users == null || users.isEmpty()){
            Thread.sleep(3000)
            users = remoteSource.getUsers()
            localSource.saveUsers(users)
        }

        return users
    }

    fun getUser(userId: Int): User{
        var user = localSource.findById(userId)
        if(user == null){
            Thread.sleep(3000)
            user = remoteSource.getUser(userId)
        }

        return user
    }

    fun deleteUser(userId: Int){
        localSource.deleteUser(userId)
    }
}