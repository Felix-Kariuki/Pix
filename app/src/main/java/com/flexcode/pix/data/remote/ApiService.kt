package com.flexcode.pix.data.remote

import com.flexcode.pix.data.remote.dto.ImageResponse
import com.flexcode.pix.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService  {

    @GET("?key=$API_KEY")
    suspend fun  searchImages(@Query("q") query: String): ImageResponse
}