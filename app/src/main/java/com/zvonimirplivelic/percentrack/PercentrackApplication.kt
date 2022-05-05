package com.zvonimirplivelic.percentrack

import android.app.Application
import timber.log.Timber

class PercentrackApplication: Application() {
    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}