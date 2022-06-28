package com.flexcode.pix.feature_image.data.remote

import com.flexcode.pix.feature_image.data.remote.dto.ImageResponse
import com.flexcode.pix.core.util.Constants
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageApiService {

    @GET("?key=${Constants.API_KEY}")
    suspend fun  getImages(@Query("q") query: String): ImageResponse
}