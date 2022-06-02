package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
class MainActivity : AppCompatActivity() {
    lateinit var myViewModel:MyViewModel
    lateinit var textView: TextView
    lateinit var button1:Button
    lateinit var button2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        textView = findViewById(R.id.textView)
        textView.text = myViewModel.number.toString()
        button1 = findViewById(R.id.button)
        button2 = findViewById(R.id.button2)
        button1.setOnClickListener {
            myViewModel.number++
            textView.text = myViewModel.number.toString()
        }

        button2.setOnClickListener {
            myViewModel.number += 2
            textView.text = myViewModel.number.toString()
        }
    }
}