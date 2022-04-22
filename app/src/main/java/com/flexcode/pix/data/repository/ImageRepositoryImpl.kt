package com.flexcode.pix.data.repository

import com.flexcode.pix.data.local.Dao
import com.flexcode.pix.data.remote.ApiService
import com.flexcode.pix.domain.model.Image
import com.flexcode.pix.domain.repository.ImageRepository
import com.flexcode.pix.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException

class ImageRepositoryImpl(
    private val apiService: ApiService,
    private val dao: Dao
): ImageRepository {
    override fun getImages(name: String): Flow<Resource<List<Image>>> = flow{

        emit(Resource.Loading())

        val images = dao.getImages(name).map { it.toImage() }
        emit(Resource.Loading(data = images))

        try {
            val remoImages = apiService.searchImages(name)
            dao.deleteImages(remoImages.hits.map { it.previewURL })
            dao.insertImages(remoImages.hits.map { it.mapToImageEntity() })

        }catch (e:HttpException) {
            emit(
                Resource.Error(
                    message = "Something went wrong",
                    data = images
                )
            )
        }catch (e:IOException){
            emit(
                Resource.Error(
                    message = "ERROR!!, check your internet connection!",
                    data = images
                )
            )
        }

        val newImages = dao.getImages(name).map { it.toImage() }
        emit(Resource.Success(newImages))
    }


}