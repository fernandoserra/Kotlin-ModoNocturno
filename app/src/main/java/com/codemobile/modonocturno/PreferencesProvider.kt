package com.codemobile.modonocturno

import android.content.Context

class PreferencesProvider(context: Context) {

    private val sharedPreferences = context.getSharedPreferences("AppSettingPrefs",0)

    fun putBoolean(Key:String, value: Boolean){
        sharedPreferences.edit().putBoolean(Key,value).apply()
    }

    fun getBoolean(Key: String):Boolean{
        return  sharedPreferences.getBoolean(Key,false)
    }

}