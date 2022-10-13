package com.joelgh.aad_2022.ut01.ex07.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.ut01.ex07.data.UserRepository
import com.joelgh.aad_2022.ut01.ex07.data.local.UserLocalSource
import com.joelgh.aad_2022.ut01.ex07.data.remote.UserRemoteSource

class Ut01Ex07Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex07)
        init()
    }

    private fun init(){
        val userRepository = UserRepository(UserLocalSource(this),UserRemoteSource())
        val users = userRepository.getUsers()
        Log.d("@dev", "Users: $users")
    }
}