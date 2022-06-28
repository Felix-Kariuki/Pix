package com.flexcode.pix.feature_image.domain.repository

import com.flexcode.pix.feature_image.domain.model.Image
import com.flexcode.pix.core.util.Resource
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    fun getImages(name: String): Flow<Resource<List<Image>>>

}