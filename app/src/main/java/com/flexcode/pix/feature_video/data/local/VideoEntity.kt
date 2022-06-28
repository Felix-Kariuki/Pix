package com.flexcode.pix.feature_video.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flexcode.pix.feature_video.domain.model.Video
import com.flexcode.pix.feature_video.domain.model.Videos

@Entity
data class VideoEntity(
    @PrimaryKey val id: Int,
    val pageURL: String,
    val type: String,
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
) {

    fun toVideo(): Video {
        return Video(
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