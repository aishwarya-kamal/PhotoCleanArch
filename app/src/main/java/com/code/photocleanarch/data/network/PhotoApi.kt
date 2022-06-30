package com.code.photocleanarch.data.network

import com.code.photocleanarch.data.model.PhotoRemote
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET

interface PhotoApi {

    @GET
    fun getPhotos(): List<PhotoRemote>
}