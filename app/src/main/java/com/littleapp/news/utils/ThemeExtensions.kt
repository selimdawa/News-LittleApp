package com.littleapp.news.utils

import android.content.Context
import androidx.preference.PreferenceManager
import com.littleapp.news.R

fun Context.applyAppTheme() {
    val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.applicationContext)
    val colorOption = sharedPreferences.getString("color_option", "BASIC")
    
    if (colorOption == "BASIC") {
        setTheme(R.style.Base_Theme_MainApp)
    }
}