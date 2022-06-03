package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodel.databinding.ActivityDataBindingBinding

class DataBinding : AppCompatActivity() {
    lateinit var MyViewModel : MyViewModel2
    //使用DataBinding 可以省略掉绑定控件的过程 直接在xml层观察数据 优化代码
    lateinit var binding : ActivityDataBindingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_data_binding)
        MyViewModel = ViewModelProvider(this).get(MyViewModel2::class.java)
        //绑定xml中的data
        binding.data = MyViewModel
        //观察数据变化
        binding.lifecycleOwner = this
    }
}