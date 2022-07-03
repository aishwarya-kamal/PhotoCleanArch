package com.code.photocleanarch.data.repository

import com.code.photocleanarch.data.network.PhotoApi
import com.code.photocleanarch.data.toPhoto
import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.domain.repository.PhotoRepository
import com.code.photocleanarch.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApi: PhotoApi
) : PhotoRepository {

    override suspend fun getPhotos(): Resource<List<Photo>> = withContext(Dispatchers.IO) {
        return@withContext try {
            Resource.loading<List<Photo>>()
            val photos = photoApi.getPhotos().map {
                it.toPhoto()
            }
            Resource.success(photos)
        } catch (e: Exception) {
            Resource.error(e.message.orEmpty())
        }
    }
}