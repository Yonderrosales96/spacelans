package com.test.spacelens

import android.app.Application
import com.test.spacelens.di.CoreModule
import com.test.spacelens.di.repositoryModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
        }
        CoreModule.init()
    }

}