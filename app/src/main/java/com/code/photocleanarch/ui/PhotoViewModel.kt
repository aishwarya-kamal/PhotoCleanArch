package com.code.photocleanarch.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.domain.repository.PhotoRepository
import com.code.photocleanarch.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private var _photos = MutableStateFlow<Resource<List<Photo>>>(Resource.success(emptyList()))
    val photos: StateFlow<Resource<List<Photo>>> = _photos.asStateFlow()

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
             photoRepository.getPhotos()
                 .collect {
                     _photos.value = it
                 }
        }
    }
}