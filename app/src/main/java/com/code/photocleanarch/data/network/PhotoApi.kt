package com.code.photocleanarch.data.network

import com.code.photocleanarch.data.model.PhotoRemote
import retrofit2.http.GET

interface PhotoApi {

    @GET("photos")
    suspend fun getPhotos(): List<PhotoRemote>
}