package com.flexcode.pix.feature_video.data.remote.dto

import java.io.Serializable

data class VideoResponse(

    val hits: List<VideoDto>,
    val total: Int,
    val totalHits: Int

):Serializable
