package com.bhargav.kotlinmvp.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

/**
 * Created by SAFARI4 on 20-09-2017.
 */
class profile {


    @SerializedName("UserName")
    @Expose
    var UserName: String? = null

    @SerializedName("Password")
    @Expose
    var Password: String? = null

}