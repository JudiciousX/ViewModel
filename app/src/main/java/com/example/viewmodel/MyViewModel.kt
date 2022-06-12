package com.example.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
//ViewModel 的生命周期与activity不同 ，它可以保证手机在横竖屏切换时不被重新创建
//只有当Activity退出时 它才会被销毁
class MyViewModel(application: Application) : AndroidViewModel(application) {
    var number = 0
}