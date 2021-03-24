package com.glushkov.wealthparktest.network

import com.glushkov.wealthparktest.data.remote.ApiResponseDto
import io.reactivex.Single
import retrofit2.http.GET

interface DataApi {
    @GET("/a2b63ef226c08553b2f9")
    fun getData() : Single<ApiResponseDto>
}