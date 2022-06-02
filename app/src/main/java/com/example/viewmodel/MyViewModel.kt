package com.example.viewmodel

import androidx.lifecycle.ViewModel
//ViewModel 的生命周期与activity不同 ，它可以保证手机在横竖屏切换时不被重新创建
//只有当Activity退出时 它才会被销毁
class MyViewModel : ViewModel() {
    var number = 0
}