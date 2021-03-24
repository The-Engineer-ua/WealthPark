package com.glushkov.wealthparktest.repository

import com.glushkov.wealthparktest.data.local.MainScreenModel
import com.glushkov.wealthparktest.data.remote.ApiResponseDto
import com.glushkov.wealthparktest.network.DataApi
import io.reactivex.Single
import io.reactivex.SingleTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Layer that handles communication between API and local code
 * @constructor pass API schema here
 */
class DataRepository @Inject constructor(private val api: DataApi) {
    fun loadData() : Single<MainScreenModel> {
        return api.getData()
            .compose(convertRemoteModelToLocal())
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    /**
     * Converts remote model to local for more convenience
     */
    private fun convertRemoteModelToLocal() : SingleTransformer<ApiResponseDto, MainScreenModel> = SingleTransformer {
        it.map { data ->
            MainScreenModel(data.cities, data.foods)
        }
    }
}