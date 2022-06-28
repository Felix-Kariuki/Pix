package com.flexcode.pix.feature_video.data.remote.dto

import com.flexcode.pix.feature_video.data.local.VideoEntity
import com.flexcode.pix.feature_video.domain.model.Videos

data class VideoDto(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val duration: Int,
    val picture_id: String,
    val videos: Videos? =Videos(),
    val views: Int,
    val downloads: Int,
    val likes: Int,
    val comments: Int,
    val user_id: Int,
    val user: String,
    val userImageURL: String
) {

    fun mapToVideoEntity() : VideoEntity {
        return VideoEntity(
            id = id,
            pageURL = pageURL,
            type = type,
            tags = tags,
            duration = duration,
            picture_id = picture_id,
            videos = videos,
            views = views,
            downloads = downloads,
            likes = likes,
            comments = comments,
            user_id = user_id,
            user = user,
            userImageURL = userImageURL
        )
    }
}