package com.flexcode.pix.feature_image.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.flexcode.pix.feature_image.domain.model.Image
import com.flexcode.pix.feature_video.domain.model.Video
import javax.inject.Inject

class ImageDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _imageDetails = MutableLiveData(savedStateHandle.get<Image>("imageDetails"))
    val imageDetails: LiveData<Image?> = _imageDetails

    private val _videoDetails = MutableLiveData(savedStateHandle.get<Video>("videoDetails"))
    val videoDetails: LiveData<Video?> = _videoDetails
}