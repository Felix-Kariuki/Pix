package com.flexcode.pix.domain.usecase

import com.flexcode.pix.domain.model.Video
import com.flexcode.pix.domain.repository.VideoRepository
import com.flexcode.pix.util.Resource
import kotlinx.coroutines.flow.Flow

class GetVideos(
    private val repository: VideoRepository
) {
    operator fun invoke(name: String): Flow<Resource<List<Video>>> {
        return repository.getVideos(name)
    }
}