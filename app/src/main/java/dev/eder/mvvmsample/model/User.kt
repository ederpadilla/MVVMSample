package dev.eder.mvvmsample.model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns

class User : BaseObservable {

    var email: String? = null

    var password: String? = null

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }

    constructor() {}

    fun isValidData() : Int{
        if (TextUtils.isEmpty(email))
            return 0
        else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches())
            return 1
        else if (password!!.length < 6)
            return 2
        else
            return -1
    }
}
