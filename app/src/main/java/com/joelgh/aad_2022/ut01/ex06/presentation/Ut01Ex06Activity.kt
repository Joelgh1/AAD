package com.joelgh.aad_2022.ut01.ex06.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import com.joelgh.aad_2022.R
import com.joelgh.aad_2022.ut01.ex06.data.local.CountLocalSource

class Ut01Ex06Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ut01_ex06)
        init()
    }

    private fun init(){
        val counter = findViewById<TextView>(R.id.form_data_count)
        val reset = findViewById<Button>(R.id.action_reset)
        val countLocalSource = CountLocalSource(this)
        countLocalSource.update()
        var timesOpened = countLocalSource.getCount()
        Log.d("@dev", "Times opened: $timesOpened")

        counter.text = timesOpened.toString()

        reset.setOnClickListener {
            countLocalSource.resetCount()
            timesOpened = countLocalSource.getCount()
            counter.text = timesOpened.toString()
            counter.setTextColor(resources.getColor(R.color.black))
        }

        if (timesOpened == 5) {
            counter.setTextColor(resources.getColor(R.color.purple_200))
            Log.d("@dev", "The app has been opened 5 times")
        }
    }
}