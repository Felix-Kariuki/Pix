package com.flexcode.pix.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.flexcode.pix.domain.model.Video

@Entity
data class VideoEntity(
    @PrimaryKey val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val duration: Int,
    val picture_id: String,
    val videos: String,
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