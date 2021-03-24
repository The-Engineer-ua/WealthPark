package com.glushkov.wealthparktest.ui.city_info.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.ui.base.BaseViewModel

/**
 * This view model is created just for fun.
 * If this app could be a bit more complex - here can be placed code that fetches data from api for specific id.
 * For now performance will be better if i will just pass model directly, as far as no more info provided inside
 */
class CityViewModel : BaseViewModel() {
    private val _cityData: MutableLiveData<CityDto> = MutableLiveData()
    val cityLiveData: LiveData<CityDto>
        get() {
            return _cityData
        }

    /**
     * Same. Just for ability to simulate error
     */
    fun validateModel(city: CityDto) {
        if (city.name.isNotEmpty() && city.image.isNotEmpty() && city.description.isNotEmpty()) {
            _cityData.postValue(city)
        }
        else {
            privateErrorData.postValue("City data is invalid. Try again later")
        }
    }
}