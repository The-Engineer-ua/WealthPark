package com.glushkov.wealthparktest.di.modules

import com.glushkov.wealthparktest.network.DataApi
import com.glushkov.wealthparktest.repository.DataRepository
import dagger.Module
import dagger.Provides

@Module
class RepositoryModule {
    @Provides
    fun provideDataRepository(api: DataApi) : DataRepository {
        return DataRepository(api)
    }
}