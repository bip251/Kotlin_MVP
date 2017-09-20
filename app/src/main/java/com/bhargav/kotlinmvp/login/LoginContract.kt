package com.bhargav.kotlinmvp.login

/**
 * Created by SAFARI4 on 20-09-2017.
 */
interface LoginContract {
    interface View{
        fun showMessage(message:String)
    }

    interface UserAction{
        fun checkLogin(Username : String,Password : String)
    }
}