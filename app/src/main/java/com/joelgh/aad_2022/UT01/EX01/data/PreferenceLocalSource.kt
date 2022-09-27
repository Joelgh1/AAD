package com.joelgh.aad_2022.UT01.EX01.data

import android.app.Activity
import android.content.Context
import com.joelgh.aad_2022.UT01.EX01.domain.Customer

class PreferenceLocalSource (private val activity: Activity){

    val Pref = activity.getPreferences(Context.MODE_PRIVATE)

    fun saveCustomer(customer: Customer){
        val editor = Pref.edit()
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

    fun getCustomer(): Customer {
        return Customer(
            Pref.getInt("id", 0),
            Pref.getString("name", "no existe")!!,
            Pref.getString("surname", "no existe")!!,
            Pref.getBoolean("is_active", false)
        )
    }
}