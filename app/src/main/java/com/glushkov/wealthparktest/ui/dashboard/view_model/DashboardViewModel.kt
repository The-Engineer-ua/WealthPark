package com.glushkov.wealthparktest.ui.dashboard.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.glushkov.wealthparktest.data.CityDto
import com.glushkov.wealthparktest.data.MealDto
import com.glushkov.wealthparktest.di.DaggerDataComponent
import com.glushkov.wealthparktest.repository.DataRepository
import com.glushkov.wealthparktest.ui.base.BaseViewModel
import io.reactivex.disposables.CompositeDisposable

class DashboardViewModel : BaseViewModel() {
    //For such simple project no complex DI integration with viewModel factory is needed
    private val dataRepo: DataRepository = DaggerDataComponent.builder().build().getDataRepository()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    private val _citiesData: MutableLiveData<List<CityDto>> = MutableLiveData()
    val citiesLiveData: LiveData<List<CityDto>>
        get() {
            return _citiesData
        }

    private val _foodData: MutableLiveData<List<MealDto>> = MutableLiveData()
    val foodLiveData: LiveData<List<MealDto>>
        get() {
            return _foodData
        }

    fun loadServerData() {
        compositeDisposable.add(dataRepo.loadData().subscribe({
            if (it.cities.isNotEmpty())
                _citiesData.postValue(it.cities)
            if (it.foods.isNotEmpty())
                _foodData.postValue(it.foods)
        }, {
            privateErrorData.postValue(it.message)
        }))
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}