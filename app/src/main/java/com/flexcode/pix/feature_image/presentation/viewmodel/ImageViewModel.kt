package com.flexcode.pix.feature_image.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flexcode.pix.feature_image.domain.model.Image
import com.flexcode.pix.feature_image.domain.use_case.GetImages
import com.flexcode.pix.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ImageViewModel @Inject constructor(
    private val getImages: GetImages
) : ViewModel(){

    private val _searchQuery = MutableLiveData("")
    val searchQuery: LiveData<String?> = _searchQuery

    fun onSearch(query: String): Flow<Resource<List<Image>>> {
        _searchQuery.value = query
        return getImages(query)
    }
}