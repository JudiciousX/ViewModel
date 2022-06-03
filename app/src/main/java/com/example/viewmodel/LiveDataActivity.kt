package com.example.viewmodel
//使用liveData观察数据 在数据发生改变的时候通知给观察者更新页面数据
//为了解决使用ViewModel按钮加减数时 当ViewModel内部开启了线程去执行一些耗时的操作时 就会发生更新数据异常的情况
//它可以包含任何类型的数据 并在数据发生改变时通知给观察者
//不用担心ViewModel内部会不会开启线程执行耗时的逻辑
//如果需要在子线程中给LiveData设置数据 需要调用postValue方法
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

        //系统给的Provider只能用来构建无参的ViewModel 有参的需要自己定义factory
        viewModelWithLiveData = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(ViewModelWithLiveData::class.java)
        //count为onChanged函数的参数名 传入一个匿名函数
        //(int) -> Unit
        viewModelWithLiveData.counter.observe(this, Observer { count ->
            textView.text = count.toString()
        })


        button1.setOnClickListener {
            viewModelWithLiveData.plusOne()
        }

        button2.setOnClickListener {
            viewModelWithLiveData.clear()
        }

    }

}