package com.mobile.wethercompose.domain

import com.mobile.wethercompose.data.response.wether_response.WetherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WetherApi {

    @GET("data/2.5/weather")
    suspend fun getWether(@Query("q") city: String, @Query("appid") appid: String): Response<WetherResponse>

}
