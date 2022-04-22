package com.flexcode.pix.domain.repository

import com.flexcode.pix.domain.model.Image
import com.flexcode.pix.util.Resource
import kotlinx.coroutines.flow.Flow

interface ImageRepository {

    fun getImages(name: String): Flow<Resource<List<Image>>>

}