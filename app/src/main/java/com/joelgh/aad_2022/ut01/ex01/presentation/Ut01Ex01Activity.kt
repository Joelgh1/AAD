package com.joelgh.aad_2022.ut01.ex01.presentation

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.ut01.ex01.data.PreferenceLocalSource
import com.joelgh.aad_2022.ut01.ex01.data.SharedPreferenceLocalSource
import com.joelgh.aad_2022.ut01.ex01.domain.Customer

class Ut01Ex01Activity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01ex01)

        initSharedPreferences()
        initPreferences()
    }

    private fun initSharedPreferences(){
        //val spCustomer: SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        //val spCustomer = SharedPreferenceLocalSource(this)
        val spCustomer: SharedPreferenceLocalSource = SharedPreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(1, "Customer1Shared", "Customer1Shared", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }

    private fun initPreferences(){
        val spCustomer: PreferenceLocalSource = PreferenceLocalSource(this)
        spCustomer.saveCustomer(Customer(2, "Customer2", "Customer2", true))

        val newCustomer = spCustomer.getCustomer()
        Log.d("@dev", "Customer $newCustomer")
    }
}