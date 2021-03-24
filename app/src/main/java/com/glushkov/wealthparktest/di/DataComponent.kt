package com.glushkov.wealthparktest.di

import com.glushkov.wealthparktest.di.modules.NetworkModule
import com.glushkov.wealthparktest.di.modules.RepositoryModule
import com.glushkov.wealthparktest.repository.DataRepository
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetworkModule::class,
    RepositoryModule::class
])
interface DataComponent {
    fun getDataRepository(): DataRepository
}