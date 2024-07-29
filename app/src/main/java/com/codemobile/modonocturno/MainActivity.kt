package com.codemobile.modonocturno

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var preferencesProvider:PreferencesProvider

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val appSettingPrefs: SharedPreferences= getSharedPreferences("AppSettingPrefs",0)
        val sharePrefsEdit:  SharedPreferences.Editor=appSettingPrefs.edit()
        val isNightModeOn: Boolean= appSettingPrefs.getBoolean("NightMode",false)*/

        preferencesProvider=PreferencesProvider(applicationContext)
        val isNightModeOn: Boolean= preferencesProvider.getBoolean("NightMode")

        if(isNightModeOn){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }else{
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        switch_btn.setOnClickListener {
            if(isNightModeOn){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                preferencesProvider.putBoolean("NightMode",false)
            }else{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                preferencesProvider.putBoolean("NightMode",true)
            }
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
    }
}