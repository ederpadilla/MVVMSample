package dev.eder.mvvmsample.viewmodel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider

import dev.eder.mvvmsample.Interface.LoginResultCallbacks

class LoginViewModelFactory(private val loginResultCallbacks: LoginResultCallbacks) :
        ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(loginResultCallbacks) as T
    }
}
