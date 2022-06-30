package com.code.photocleanarch.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.code.photocleanarch.data.toPhoto
import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.domain.repository.PhotoRepository
import dagger.hilt.android.scopes.ViewModelScoped
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.launch
import javax.inject.Inject

@ViewModelScoped
class PhotoViewModel @Inject constructor(
    private val photoRepository: PhotoRepository
) : ViewModel() {

    private var _photos = MutableLiveData<List<Photo>>(emptyList())
    val photos: LiveData<List<Photo>> = _photos

    init {
        getPhotos()
    }

    private fun getPhotos() {
        viewModelScope.launch {
             _photos.value = photoRepository.getPhotos().map {
                 it.toPhoto()
             }
        }
    }
}