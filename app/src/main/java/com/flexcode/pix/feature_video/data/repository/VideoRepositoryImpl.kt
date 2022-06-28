package com.flexcode.pix.feature_video.data.repository


import com.flexcode.pix.feature_video.data.local.VideoDao
import com.flexcode.pix.feature_video.data.remote.VideoApiService
import com.flexcode.pix.feature_video.domain.model.Video
import com.flexcode.pix.feature_video.domain.repository.VideoRepository
import com.flexcode.pix.core.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class VideoRepositoryImpl(
    private val apiService: VideoApiService,
    private val dao: VideoDao
) : VideoRepository {
    override fun getVideos(name: String): Flow<Resource<List<Video>>> = flow {

        emit(Resource.Loading())

        //read data in cache
        val videos = dao.getVideos(name).map { it.toVideo() }
        emit(Resource.Loading(data = videos))

        try {
            val remoteVideos = apiService.searchVideos(name)
            dao.deleteVideos(remoteVideos.hits.map { it.pageURL })
            dao.insertVideos(remoteVideos.hits.map { it.mapToVideoEntity() })
        } catch (e: HttpException) {
            emit(
                Resource.Error(
                    message = "Something went wrong",
                    data = videos
                )
            )
        } catch (e: IOException) {
            emit(
                Resource.Error(
                    message = "ERROR!!, check your internet connection!",
                    data = videos
                )
            )
        }

        val newVideos = dao.getVideos(name).map { it.toVideo() }
        emit(Resource.Success(newVideos))


    }


}