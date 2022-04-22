package com.flexcode.pix.domain.usecase

import com.flexcode.pix.domain.model.Image
import com.flexcode.pix.domain.repository.ImageRepository
import com.flexcode.pix.util.Resource
import kotlinx.coroutines.flow.Flow

class GetImages(
    private val repository: ImageRepository
) {

    operator fun invoke(name: String): Flow<Resource<List<Image>>> {
        return repository.getImages(name)
    }
}