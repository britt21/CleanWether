package com.mobile.wethercompose.domain

import com.mobile.wethercompose.data.response.wether_response.WetherResponse
import retrofit2.Response

interface WetherRepo {

    suspend fun getWether(city: String,appid: String): Response<WetherResponse>
}