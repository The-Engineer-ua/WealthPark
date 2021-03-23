package com.glushkov.wealthparktest.data.local

import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.data.MealDto

data class MainScreenModel(val cities: List<CityDto>, val foods: List<MealDto>)
