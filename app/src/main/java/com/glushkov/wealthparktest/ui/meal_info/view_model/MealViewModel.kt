package com.glushkov.wealthparktest.ui.meal_info.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.glushkov.wealthparktest.data.MealDto
import com.glushkov.wealthparktest.ui.base.BaseViewModel

/**
 * This view model is created just for fun.
 * If this app could be a bit more complex - here can be placed code that fetches data from api for specific id.
 * For now performance will be better if i will just pass model directly, as far as no more info provided inside
 */
class MealViewModel : BaseViewModel() {
    private val _mealData: MutableLiveData<MealDto> = MutableLiveData()
    val mealLiveData: LiveData<MealDto>
        get() {
            return _mealData
        }

    /**
     * Same. Just for ability to simulate error
     */
    fun validateModel(meal: MealDto) {
        if (meal.name.isNotEmpty() && meal.image.isNotEmpty()) {
            _mealData.postValue(meal)
        }
        else {
            privateErrorData.postValue("Meal data is invalid. Try again later")
        }
    }
}