package com.codemobile.modonocturno

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //https://www.youtube.com/watch?v=QhGf8fGJM8U

        val appSettingPrefs: SharedPreferences= getSharedPreferences("AppSettingPrefs",0)
        val sharePrefsEdit:  SharedPreferences.Editor=appSettingPrefs.edit()
        val isNightModeOn: Boolean= appSettingPrefs.getBoolean("NightMode",false)

        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        switch_btn.setOnClickListener {
            if(isNightModeOn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                sharePrefsEdit.putBoolean("NightMode",false)
                sharePrefsEdit.apply()
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                sharePrefsEdit.putBoolean("NightMode",true)
                sharePrefsEdit.apply()
            }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}