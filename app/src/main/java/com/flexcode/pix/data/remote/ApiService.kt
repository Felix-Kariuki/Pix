package com.flexcode.pix.data.remote

import com.flexcode.pix.data.remote.dto.ImageResponse
import com.flexcode.pix.data.remote.dto.VideoResponse
import com.flexcode.pix.util.Constants.API_KEY
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface ApiService  {

    @GET("?key=$API_KEY")
    suspend fun  getImages(@Query("q") query: String): ImageResponse

    @Headers("Content-Type: text/html")
    @GET("videos/?key=$API_KEY")
    suspend fun  searchVideos(@Query("q") query: String): VideoResponse
}