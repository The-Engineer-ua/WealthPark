package com.glushkov.wealthparktest.data.local

import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.data.MealDto

data class MainScreenModel(var cities: List<CityDto> = listOf(), var foods: List<MealDto> = listOf())
