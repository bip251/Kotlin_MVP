package com.bhargav.kotlinmvp.application

import android.content.Context
import android.content.SharedPreferences
import com.bhargav.kotlinmvp.model.profile
import com.google.gson.Gson

import com.google.gson.GsonBuilder



/**
 * Created by SAFARI4 on 20-09-2017.
 */
object SessionUtils {
    private val PREF = "prefs"
    private val USER_PROFILE = "user_profile"

    fun getSession(context: Context): SharedPreferences {
        return context.getSharedPreferences(PREF, Context.MODE_PRIVATE)
    }

    fun setUserProfile(context: Context, ProfileData: profile) {
        val jsonProfile = Gson().toJson(ProfileData)
        getSession(context).edit().putString(USER_PROFILE, jsonProfile).apply()
    }

    fun getUserProfile(context: Context): profile {
        val json = getSession(context).getString(USER_PROFILE, null)
//        return Gson()?.fromJson<profile>(json, profile::class.java::class.java!!)

        val gsonObj = Gson()
        val vehicles = gsonObj.fromJson(json, profile::class.java)
        return vehicles
    }

//    final Gson gson = new GsonBuilder()
//    .excludeFieldsWithoutExposeAnnotation()
//    .excludeFieldsWithModifiers(TRANSIENT) // STATIC|TRANSIENT in the default configuration
//    .create();
//    final String json = gson.toJson(new DyescapeCOREConfiguration());
//    System.out.println(json);

    fun clearSession(context: Context) {
        getSession(context).edit().clear().apply()
    }

}