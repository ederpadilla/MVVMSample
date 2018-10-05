package dev.eder.mvvmsample.viewmodel

import android.app.Activity
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import dev.eder.mvvmsample.Interface.LoginResultCallbacks

class LoginViewModelFactory(private val loginResultCallbacks: LoginResultCallbacks, private val activity: Activity) :
        ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginResultCallbacks,activity) as T
    }
}
