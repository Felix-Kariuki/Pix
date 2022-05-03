package com.flexcode.pix.data.mapper

import com.flexcode.pix.data.local.ImageEntity
import com.flexcode.pix.data.remote.dto.ImageDto
import com.flexcode.pix.domain.model.Image

fun ImageDto.toImageEntity(): ImageEntity {
    return ImageEntity(
        id = id,
        pageURL = pageURL,
        type = type,
        tags = tags,
        previewURL = previewURL,
        previewWidth = previewWidth,
        previewHeight = previewHeight,
        webformatURL = webformatURL,
        webformatWidth = webformatWidth,
        webformatHeight = webformatHeight,
        largeImageURL = largeImageURL,
        imageWidth = imageWidth,
        imageHeight = imageHeight,
        imageSize = imageSize,
        views = views,
        downloads = downloads,
        collections = collections,
        likes = likes,
        comments = comments,
        userId = userId,
        user = user,
        userImageURL = userImageURL,
    )
}

fun ImageEntity.toImage(): Image {
    return Image(
        id = id,
        pageURL = pageURL,
        type = type,
        tags = tags,
        previewURL = previewURL,
        previewWidth = previewWidth,
        previewHeight = previewHeight,
        webformatURL = webformatURL,
        webformatWidth = webformatWidth,
        webformatHeight = webformatHeight,
        largeImageURL = largeImageURL,
        imageWidth = imageWidth,
        imageHeight = imageHeight,
        imageSize = imageSize,
        views = views,
        downloads = downloads,
        collections = collections,
        likes = likes,
        comments = comments,
        userId = userId,
        user = user,
        userImageURL = userImageURL,
    )
}

