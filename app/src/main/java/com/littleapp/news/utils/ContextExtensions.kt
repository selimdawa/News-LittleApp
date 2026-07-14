package com.littleapp.news.utils

import android.app.Activity
import android.content.Context
import android.content.Intent

fun <T : Activity> Context.launchActivity(cls: Class<T>, finish: Boolean = false) {
    val intent = Intent(this, cls)
    startActivity(intent)
    if (finish && this is Activity) {
        this.finish()
    }
}
