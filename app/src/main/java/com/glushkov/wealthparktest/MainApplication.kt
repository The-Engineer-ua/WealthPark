package com.glushkov.wealthparktest

import android.app.Application
import com.glushkov.wealthparktest.di.ApplicationComponent
import com.glushkov.wealthparktest.di.DaggerApplicationComponent

class MainApplication: Application() {
    // Reference to the application graph that is used across the whole app
    val appComponent: ApplicationComponent = DaggerApplicationComponent.create()
}
