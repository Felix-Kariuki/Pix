package com.flexcode.pix.domain.repository

import com.flexcode.pix.domain.model.Video
import com.flexcode.pix.util.Resource
import kotlinx.coroutines.flow.Flow

interface VideoRepository {

    fun getVideos(name: String): Flow<Resource<List<Video>>>

}