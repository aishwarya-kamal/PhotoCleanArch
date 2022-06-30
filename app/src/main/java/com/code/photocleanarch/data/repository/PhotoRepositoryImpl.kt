package com.code.photocleanarch.data.repository

import com.code.photocleanarch.data.model.PhotoRemote
import com.code.photocleanarch.data.network.PhotoApi
import com.code.photocleanarch.domain.repository.PhotoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApi: PhotoApi
) : PhotoRepository {

    override suspend fun getPhotos(): List<PhotoRemote> = photoApi.getPhotos()

}