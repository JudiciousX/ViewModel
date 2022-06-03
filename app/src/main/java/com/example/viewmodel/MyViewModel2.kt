package com.example.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MyViewModel2 : ViewModel(){
    private val _counter = MutableLiveData<Int>()


    val counter : LiveData<Int> = _counter


    init {
        _counter.value = 0
    }

    fun add() {
        _counter.value = (counter.value ?: 0) + 1
    }
}