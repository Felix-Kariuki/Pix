package com.flexcode.pix.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.flexcode.pix.domain.model.Image
import javax.inject.Inject

class ImageDetailsViewModel @Inject constructor(
    savedStateHandle: SavedStateHandle
): ViewModel() {
    private val _imageDetails = MutableLiveData(savedStateHandle.get<Image>("imageDetails"))
    val imageDetails: LiveData<Image?> = _imageDetails
}