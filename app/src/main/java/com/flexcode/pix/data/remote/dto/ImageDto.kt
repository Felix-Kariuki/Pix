package com.flexcode.pix.data.remote.dto

import com.flexcode.pix.data.local.ImageEntity

data class ImageDto(
    val id: Int,
    val pageURL: String,
    val type: String,
    val tags: String,
    val previewURL: String,
    val previewWidth: Int,
    val previewHeight: Int,
    val webformatURL: String,
    val webformatWidth: Int,
    val webformatHeight: Int,
    val largeImageURL: String,
    val imageWidth: Int,
    val imageHeight: Int,
    val imageSize: Int,
    val views: Int,
    val downloads: Int,
    val collections: Int,
    val likes: Int,
    val comments: Int,
    val userId: Int,
    val user: String,
    val userImageURL: String
) {
    /*
        *
        * mapping domain image data  to image entity
        *
        *
     */

    fun mapToImageEntity(): ImageEntity {
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

}