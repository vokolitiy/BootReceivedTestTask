package com.example.auratesttask

import android.app.Application
import io.realm.Realm

class TestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
    }
}