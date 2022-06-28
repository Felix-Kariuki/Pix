package com.flexcode.pix.feature_video.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val id: Int,
    val pageURL: String,
    val type : String,
    val tags: String,
    val duration: Int,
    val picture_id: String,
    val videos: Videos? = Videos(),
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user_id: Int,
    val user: String,
    val userImageURL: String
) : Parcelable