package com.joelgh.aad_2022.ut01.ex05.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.ut01.ex05.data.users.UserRepository
import com.joelgh.aad_2022.ut01.ex05.data.users.local.UsersLocalDataSource
import com.joelgh.aad_2022.ut01.ex05.data.users.remote.UsersRemoteDataSource

class Ut01Ex05Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex05)

        init()
    }

    private fun init(){
        val userRepository = UserRepository(
            UsersLocalDataSource(this),
            UsersRemoteDataSource()
        )
    }
}