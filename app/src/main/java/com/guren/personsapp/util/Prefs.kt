package com.guren.personsapp.util

import android.content.Context
import android.content.SharedPreferences
import com.guren.personsapp.R

class Prefs (ctx:Context){

    val prefs: SharedPreferences =
        ctx.getSharedPreferences(ctx.getString(R.string.prefs), Context.MODE_PRIVATE)



    fun clear() {
        try {
            prefs.edit().clear().apply()
        } catch (e: Exception) {


        }
    }


}