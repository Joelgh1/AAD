package com.joelgh.aad_2022.ut01.ex06.data.local

import android.app.Activity
import android.content.Context

class CountLocalSource(val activity: Activity) {

    val sharedPrefs = activity.getPreferences(Context.MODE_PRIVATE)
    val editor = sharedPrefs.edit()
    val key = "times_opened"

    fun update(){
        var count = sharedPrefs.getInt(key, 0)

        if(count == 0){
            editor.putInt(key, 1)
            editor.apply()
        }else{
            count++
            editor.putInt(key, count)
            editor.apply()
        }
    }

    fun getCount() = sharedPrefs.getInt(key, 0)

    fun resetCount(){
        editor.putInt(key, 0)
        editor.apply()
    }
}