package dev.eder.mvvmsample.view

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import dev.eder.mvvmsample.Interface.LoginResultCallbacks
import dev.eder.mvvmsample.R
import dev.eder.mvvmsample.databinding.ActivityMainBinding
import dev.eder.mvvmsample.viewmodel.LoginViewModel
import dev.eder.mvvmsample.viewmodel.LoginViewModelFactory
import es.dmoral.toasty.Toasty


class MainActivity : AppCompatActivity() , LoginResultCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,
                R.layout.activity_main)
        activityMainBinding.viewModel = ViewModelProviders.of(
                this,
                LoginViewModelFactory(this))
                .get(LoginViewModel::class.java)
    }

    override fun onSuccess(message: String) {
        Toasty.success(this@MainActivity,message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this@MainActivity,message, Toast.LENGTH_SHORT).show()

    }

}
