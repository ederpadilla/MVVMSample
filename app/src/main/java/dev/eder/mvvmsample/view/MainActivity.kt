package dev.eder.mvvmsample.view

import android.app.Activity
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import dev.eder.mvvmsample.Interface.LoginResultCallbacks
import dev.eder.mvvmsample.R
import dev.eder.mvvmsample.databinding.ActivityMainBinding
import dev.eder.mvvmsample.viewmodel.LoginViewModel
import dev.eder.mvvmsample.viewmodel.LoginViewModelFactory
import es.dmoral.toasty.Toasty


class MainActivity : AppCompatActivity() , LoginResultCallbacks {

    lateinit var activityMainBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = DataBindingUtil.setContentView(this,
                R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(
                this,
                LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)
    }

    //method to Process Login
    fun onLongInCLick(view: View) {
        hideKeyboard()
        activityMainBinding.viewModel!!.setUpErrorCode()
    }

    fun hideKeyboard() {
        val imm = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = currentFocus
        if (view == null) {
            view = View(this)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    override fun onSuccess(message: String) {
        Toasty.success(this@MainActivity,message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this@MainActivity,message, Toast.LENGTH_SHORT).show()
    }
}
