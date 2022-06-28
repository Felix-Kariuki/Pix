package com.flexcode.pix.feature_image.data.remote.dto

import com.flexcode.pix.feature_image.data.remote.dto.ImageDto
import java.io.Serializable

data class ImageResponse(
    val hits: List<ImageDto>,
    val total: Int,
    val totalHits: Int

) : Serializable