package com.joelgh.aad_2022.ut01.ex02.data

import android.app.Activity
import android.content.Context
import com.joelgh.aad_2022.ut01.ex02.presentation.Ut01Ex02Activity

class PreferenceLocalStorage (private val activity: Ut01Ex02Activity){

    val pref = activity.getPreferences(Context.MODE_PRIVATE)
    val editor = pref.edit()

    fun saveFirstTime(){
        editor.putBoolean("already_opened", true)
        editor.apply()
    }

    fun checkFirstTime(): Boolean{
        val check = pref.getBoolean("already_opened", false)

        if(check){
            return false
        }else{
            this.saveFirstTime()
            return true
        }
    }
}