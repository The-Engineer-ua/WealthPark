package com.glushkov.wealthparktest.network

import com.glushkov.wealthparktest.data.remote.ApiResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface DataApi {
    @GET
    fun getData() : Single<ApiResponseDto>
}