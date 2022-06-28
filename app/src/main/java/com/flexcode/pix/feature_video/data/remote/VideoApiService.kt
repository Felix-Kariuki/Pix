package com.flexcode.pix.feature_video.data.remote

import com.flexcode.pix.feature_video.data.remote.dto.VideoResponse
import com.flexcode.pix.core.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface VideoApiService  {



    @Headers("Content-Type: text/html")
    @GET("videos/?key=$API_KEY")
    suspend fun  searchVideos(@Query("q") query: String): VideoResponse
}