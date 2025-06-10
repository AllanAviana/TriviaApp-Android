package com.example.triviaapp_android

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TriviaApplication: Application() {
    override fun onCreate() {
        super.onCreate()
    }
}