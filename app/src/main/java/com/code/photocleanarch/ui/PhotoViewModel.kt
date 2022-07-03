package com.code.photocleanarch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.domain.repository.PhotoRepository
import com.code.photocleanarch.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private var _photos = MutableLiveData<Resource<List<Photo>>>()
    val photos: LiveData<Resource<List<Photo>>> = _photos

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
             _photos.value = photoRepository.getPhotos()
        }
    }
}