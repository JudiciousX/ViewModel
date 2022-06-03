package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
//保证了数据的封装性
class ViewModelWithLiveData: ViewModel() {
    //使用private修饰_counter保证其可以在外部不被修改

    private val _counter = MutableLiveData<Int>()

    //使用LiveData包装_counter 通过该属性的get方法获取_counter的值
    //LiveData是不可改变的 因此不用担心暴露给外部
    val counter:LiveData<Int>
        get() = _counter

    init {
        _counter.value ?: 0
    }

    fun plusOne() {
        _counter.value = (counter.value ?: 0) + 1
    }

    fun clear() {
        _counter.value = 0
    }
}