package com.example.flickerphotossearexample.common

import android.app.Application
import android.content.Context
import java.lang.ref.WeakReference

/**
 * created by Mohammad Sajjad
 * on 22-01-2021 at 11:41
 * mohammadsajjad679@gmail.com
 */
class App : Application() {
     var appContext: Context? = null

    override fun onCreate() {
        super.onCreate()
                appContext = applicationContext;

    }

}