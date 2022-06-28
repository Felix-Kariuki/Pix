package com.flexcode.pix.feature_video.domain.repository

import com.flexcode.pix.feature_video.domain.model.Video
import com.flexcode.pix.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    fun getVideos(name: String): Flow<Resource<List<Video>>>

}