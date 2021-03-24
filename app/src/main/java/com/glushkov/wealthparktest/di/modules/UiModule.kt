package com.glushkov.wealthparktest.di.modules

import com.glushkov.wealthparktest.ui.adapters.CitiesAdapter
import com.glushkov.wealthparktest.ui.adapters.FoodAdapter
import dagger.Module
import dagger.Provides

@Module
class UiModule {
    @Provides
    fun provideCitiesAdapter(): CitiesAdapter {
        return CitiesAdapter()
    }

    @Provides
    fun provideFoodAdapter(): FoodAdapter {
        return FoodAdapter()
    }
}