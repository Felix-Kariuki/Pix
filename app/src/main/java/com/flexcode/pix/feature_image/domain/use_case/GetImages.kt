package com.flexcode.pix.feature_image.domain.use_case

import com.flexcode.pix.feature_image.domain.model.Image
import com.flexcode.pix.feature_image.domain.repository.ImageRepository
import com.flexcode.pix.core.util.Resource
import kotlinx.coroutines.flow.Flow

class GetImages(
    private val repository: ImageRepository
) {

    operator fun invoke(name: String): Flow<Resource<List<Image>>> {
        return repository.getImages(name)
    }
}