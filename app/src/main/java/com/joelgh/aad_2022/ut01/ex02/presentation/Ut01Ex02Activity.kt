package com.joelgh.aad_2022.ut01.ex02.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.ut01.ex02.data.PreferenceLocalStorage

class Ut01Ex02Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex02)
        initPreferences()
    }

    fun initPreferences(){
        val pFirstTime = PreferenceLocalStorage(this)
        if (pFirstTime.checkFirstTime()){
            Log.d("@dev", "First time opened")
        }
    }
}