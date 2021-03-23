package com.glushkov.wealthparktest.data.remote

import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.data.MealDto

data class ApiResponseDto(val cities: List<CityDto>, val foods: List<MealDto>)
