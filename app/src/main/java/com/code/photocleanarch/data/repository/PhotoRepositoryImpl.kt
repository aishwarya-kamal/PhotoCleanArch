package com.code.photocleanarch.data.repository

import com.code.photocleanarch.data.network.PhotoApi
import com.code.photocleanarch.data.toPhoto
import com.code.photocleanarch.domain.model.Photo
import com.code.photocleanarch.domain.repository.PhotoRepository
import com.code.photocleanarch.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class PhotoRepositoryImpl @Inject constructor(
    private val photoApi: PhotoApi
) : PhotoRepository {

    override fun getPhotos(): Flow<Resource<List<Photo>>> = flow {
        emit(Resource.loading())
        try {
            val photos = photoApi.getPhotos()
                .map { photoRemote ->
                    photoRemote.toPhoto()
                }
            emit(Resource.success(photos))
        } catch (e: IllegalStateException) {
            emit(Resource.error(e.message.orEmpty()))
        }
    }.flowOn(Dispatchers.IO)
}

//    override suspend fun getPhotos(): Flow<Resource<List<Photo>>> {
////            emit(Resource.loading())
//            val photos = photoApi.getPhotos().asFlow()
//
//            photos
//            .flowOn(Dispatchers.IO)
//            .catch { e ->
//                emit(Resource.error(e.message.orEmpty()))
//            }
//            .collect {
//                emit(Resource.success(photos))
//            }
//    }


//    override suspend fun getPhotos(): Flow<Resource<List<Photo>>> {
//        try {
//            val photos = photoApi.getPhotos()
//                .map { photoRemote -> photoRemote.toPhoto() }
//                .asFlow()
//                .flowOn(Dispatchers.IO)
//            return emit(Resource.success(photos))
//        } catch (e: IllegalStateException) {
//            emit(Resource.error(e.message.orEmpty()))
//        }
////        return photoApi.getPhotos()
////            .asFlow()
////            .catch { emit(Resource.error<>()) }
////            .flowOn(Dispatchers.IO)
//    }


//private fun <T> Flow<T>.handleErrors() = flow {
//    try {
//        collect { emit(Resource.success(it)) }
//    } catch (e: IllegalStateException) {
//        emit(Resource.error<List<Photo>>(e.message.orEmpty()))
//    }
//}
