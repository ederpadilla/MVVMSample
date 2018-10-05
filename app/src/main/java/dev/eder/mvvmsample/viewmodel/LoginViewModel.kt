package dev.eder.mvvmsample.viewmodel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View

import dev.eder.mvvmsample.Interface.LoginResultCallbacks
import dev.eder.mvvmsample.model.User
import android.app.Activity
import android.view.inputmethod.InputMethodManager


class LoginViewModel(private val loginResultCallbacks: LoginResultCallbacks, private val activity: Activity) : ViewModel() {

    private val user: User

    //Method to getEmail and get Password from Edittext and set to the user
    val emailTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(mail: Editable) {
                user.email = mail.toString()
            }
        }


    val passwordTextWatcher: TextWatcher
        get() = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(password: Editable) {
                user.password = password.toString()
            }
        }

    init {
        this.user = User()
    }

    //method to Process Login
    fun onLonginCLicked(view: View) {
        hideKeyboard()
        val errorCode = user.isValidData()
        when (errorCode) {
            0 -> loginResultCallbacks.onError("Campos vacios")
            1 -> loginResultCallbacks.onError("Email invalido")
            2 -> loginResultCallbacks.onError("Contraseña muy corta")
            -1 -> loginResultCallbacks.onSuccess("LoginSuccess!")
        }
    }

    fun hideKeyboard() {

        val imm = activity.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = activity.currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
