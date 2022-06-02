package com.example.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelWithLiveData: ViewModel() {
    val counter = MutableLiveData<Int>()

    init {
        counter.value ?: 0
    }

    fun plusOne() {
        counter.value = (counter.value ?: 0) + 1
    }

    fun clear() {
        counter.value = 0
    }
}