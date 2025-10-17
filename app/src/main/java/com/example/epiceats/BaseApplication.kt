package com.example.epiceats

import android.app.Application
import com.google.firebase.Firebase
import com.google.firebase.initialize
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class BaseApplication: Application() {
    override fun onCreate(){
        super.onCreate()
        Firebase.initialize(this)
    }
}