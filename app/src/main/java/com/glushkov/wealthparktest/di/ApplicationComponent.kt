package com.glushkov.wealthparktest.di

import com.glushkov.wealthparktest.di.modules.UiModule
import com.glushkov.wealthparktest.ui.dashboard.DashboardFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    UiModule::class
])
interface ApplicationComponent {
    fun inject(fragment: DashboardFragment)
}