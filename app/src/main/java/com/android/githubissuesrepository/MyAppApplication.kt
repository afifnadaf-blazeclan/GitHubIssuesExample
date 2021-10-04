package com.android.githubissuesrepository

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/**
 * Created by Afif Nadaf on 03/10/21.
 */
@HiltAndroidApp
class MyAppApplication : Application() {

    override fun onCreate() {
        super.onCreate()
    }
}