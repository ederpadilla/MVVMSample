package dev.eder.mvvmsample.Interface

interface LoginResultCallbacks {

    fun onSuccess(message : String)

    fun onError(message: String)

}