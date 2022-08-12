package com.code.photocleanarch.domain.repository

import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.utils.Resource
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    fun getPhotos(): Flow<Resource<List<Photo>>>
}