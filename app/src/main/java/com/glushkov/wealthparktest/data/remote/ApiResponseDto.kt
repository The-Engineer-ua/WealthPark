package com.glushkov.wealthparktest.data.remote

import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.data.MealDto

data class ApiResponseDto(var cities: List<CityDto> = listOf(), var foods: List<MealDto> = listOf())
