package com.bhargav.kotlinmvp.login

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.widget.Toast
import com.bhargav.kotlinmvp.MainActivity
import com.bhargav.kotlinmvp.model.profile
import kotlinx.android.synthetic.main.activity_login.*

/**
 * Created by SAFARI4 on 20-09-2017.
 */
class LoginPresenter(mContext : Context, activityView : LoginContract.View, profileDetails : profile) : LoginContract.UserAction {

    var context : Context? = null
    var mView : LoginContract.View? = null
    var profileData : profile? = null
    init{
        this.context = mContext
        this.mView = activityView
        this.profileData = profileDetails
    }

    override fun checkLogin(Username: String, Password: String) {
        if(Username.isEmpty()){
            mView?.showMessage("Please enter the username.")
        }else if(Password.isEmpty()){
            mView?.showMessage("Please enter the password")
        }else if(Username.equals(profileData?.UserName) && Password.equals(profileData?.Password)){
            mView?.showMessage("Login Successful")
            context?.startActivity(Intent(context, MainActivity::class.java))
        }else{
            mView?.showMessage("Invalid username and password")
        }
    }

}