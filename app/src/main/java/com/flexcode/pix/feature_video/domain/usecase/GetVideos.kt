package com.flexcode.pix.feature_video.domain.usecase

import com.flexcode.pix.feature_video.domain.model.Video
import com.flexcode.pix.feature_video.domain.repository.VideoRepository
import com.flexcode.pix.core.util.Resource
import kotlinx.coroutines.flow.Flow

class GetVideos(
    private val repository: VideoRepository
) {
    operator fun invoke(name: String): Flow<Resource<List<Video>>> {
        return repository.getVideos(name)
    }
}