package com.example.viewmodel
//ViewModel 实现按钮加数 并使用ViewModel保存数据
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
class MainActivity : AppCompatActivity() {
    //lateinit
    lateinit var textView: TextView
    lateinit var button1:Button
    lateinit var button2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        val myViewModel:MyViewModel by viewModels<MyViewModel>()

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