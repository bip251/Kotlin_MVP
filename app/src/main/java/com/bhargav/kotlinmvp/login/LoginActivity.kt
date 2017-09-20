package com.bhargav.kotlinmvp.login

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.bhargav.kotlinmvp.R
import com.bhargav.kotlinmvp.application.SessionUtils
import com.bhargav.kotlinmvp.model.profile
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by SAFARI4 on 20-09-2017.
 */
class LoginActivity : AppCompatActivity(), LoginContract.View {
    override fun showMessage(message: String) {
        Toast.makeText(this@LoginActivity,message,Toast.LENGTH_LONG).show()
    }

    var mContext : Context? = null
    var mPresenter : LoginPresenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initialize()
    }

    fun initialize(){

        var data : profile = profile()
        data.UserName = "admin"
        data.Password = "123"

        SessionUtils.setUserProfile(this@LoginActivity, data)

        var profileData : profile = profile()

        if(SessionUtils.getUserProfile(this@LoginActivity) != null){
            mPresenter = LoginPresenter(this@LoginActivity, this, SessionUtils.getUserProfile(this@LoginActivity))
        }

        btnLogin.setOnClickListener {
            mPresenter?.checkLogin(eUsername.text.toString().trim(),ePassword.text.toString().trim())
        }
    }

}