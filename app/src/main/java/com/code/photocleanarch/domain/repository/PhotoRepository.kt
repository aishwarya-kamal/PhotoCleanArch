package com.code.photocleanarch.domain.repository

import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.utils.Resource

interface PhotoRepository {

    suspend fun getPhotos(): Resource<List<Photo>>
}