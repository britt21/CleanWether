package com.mobile.wethercompose.domain

import com.mobile.wethercompose.data.response.wether_response.WetherResponse
import retrofit2.Response

class WetherRepoImpl(var wetherApi: WetherApi) : WetherRepo{
    override suspend fun getWether(city: String,appid: String): Response<WetherResponse> {
        return wetherApi.getWether(city,appid)
    }

}