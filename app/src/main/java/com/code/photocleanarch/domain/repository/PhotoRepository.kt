package com.code.photocleanarch.domain.repository

import com.code.photocleanarch.data.model.PhotoRemote
import kotlinx.coroutines.flow.Flow

interface PhotoRepository {

    suspend fun getPhotos(): List<PhotoRemote>
}