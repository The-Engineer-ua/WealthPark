package com.glushkov.wealthparktest.ui.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    protected val privateErrorData: MutableLiveData<String> = MutableLiveData()

    val errorLiveData: LiveData<String>
        get() {
            return privateErrorData
        }
}