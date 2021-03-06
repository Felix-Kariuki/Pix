package com.flexcode.pix.feature_video.presentation.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.flexcode.pix.feature_video.domain.model.Video
import com.flexcode.pix.feature_video.domain.usecase.GetVideos
import com.flexcode.pix.core.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class VideoViewModel @Inject constructor(
    private val getVideos: GetVideos
) : ViewModel(){

    private val _searchQuery = MutableLiveData("")
    val searchQuery: LiveData<String?> = _searchQuery

    fun onSearch(query: String): Flow<Resource<List<Video>>> {
        _searchQuery.value = query
        return getVideos(query)
    }
}
