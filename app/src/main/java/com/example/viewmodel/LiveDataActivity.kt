package com.example.viewmodel

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.TaskStackBuilder
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class LiveDataActivity : AppCompatActivity()  {
    lateinit var viewModelWithLiveData: ViewModelWithLiveData

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.textView)
        val button1 = findViewById<Button>(R.id.button)
        val button2 = findViewById<Button>(R.id.button2)

        viewModelWithLiveData = ViewModelProvider(this).get(ViewModelWithLiveData::class.java)
        val count = viewModelWithLiveData.counter.value
        viewModelWithLiveData.counter.observe(this, Observer { count ->
            textView.text = count.toString()
         })

        button1.setOnClickListener {
            viewModelWithLiveData.plusOne()
        }

        button1.setOnClickListener {
            viewModelWithLiveData.clear()
        }

    }


}