package com.joelgh.aad_2022.UT01.EX01.data

import android.content.Context
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.UT01.EX01.presentation.Ut01Ex01Activity
import com.joelgh.aad_2022.UT01.EX01.domain.Customer

class SharedPreferenceLocalSource(val activity: Ut01Ex01Activity){

    val sharedPref = activity.getSharedPreferences(
        activity.getString(R.string.preference_ut01ex01), Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){
        val editor = sharedPref.edit()
        //Java style

        editor.putInt("id", customer.id)
        editor.putString("name", customer.name)
        editor.putString("surname", customer.surname)
        editor.putBoolean("is_active", customer.inactive)
        editor.apply() //asincrono

        //editor.commit() sincrono

        //Kotlin style
        /*editor.apply {
            putInt("id", customer.id)
            putString("name", customer.name)
            putString("surname", customer.surname)
            putBoolean("is_active", customer.inactive)
        }*/
    }

    fun getCustomer(): Customer{
        return Customer(
            sharedPref.getInt("id", 0),
            sharedPref.getString("name", "no existe")!!,
            sharedPref.getString("surname", "no existe")!!,
            sharedPref.getBoolean("is_active", false)
        )
    }
}