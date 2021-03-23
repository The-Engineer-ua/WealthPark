package com.glushkov.wealthparktest

import com.glushkov.wealthparktest.data.remote.ApiResponseDto
import com.glushkov.wealthparktest.data.apiResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ApiParseTest {
    lateinit var gson: Gson

    @Before
    fun initGson() {
        gson = GsonBuilder().create()
    }

    @Test
    fun testResponseParsable() {
        val data = gson.fromJson<ApiResponseDto>(apiResponse, object: TypeToken<ApiResponseDto>() {}.type)

        Assert.assertNotNull(data)
    }

    @Test
    fun testResponseAllFoods() {
        val data = gson.fromJson<ApiResponseDto>(apiResponse, object: TypeToken<ApiResponseDto>() {}.type)
        Assert.assertEquals(data.foods.size, 4)
    }

    @Test
    fun testResponseAllCities() {
        val data = gson.fromJson<ApiResponseDto>(apiResponse, object: TypeToken<ApiResponseDto>() {}.type)
        Assert.assertEquals(data.cities.size, 3)
    }

    @Test
    fun testResponseImageAvailableMeal() {
        val data = gson.fromJson<ApiResponseDto>(apiResponse, object: TypeToken<ApiResponseDto>() {}.type)
        Assert.assertEquals(data.foods.firstOrNull()?.image, "https://robata-kaba.jp/wp-content/uploads/2020/02/susi.jpg")
    }

    @Test
    fun testResponseImageAvailableCity() {
        val data = gson.fromJson<ApiResponseDto>(apiResponse, object: TypeToken<ApiResponseDto>() {}.type)
        Assert.assertEquals(data.cities.firstOrNull()?.image, "https://rimage.gnst.jp/livejapan.com/public/article/detail/a/00/01/a0001379/img/basic/a0001379_main.jpg")
    }
}