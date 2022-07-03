package com.code.photocleanarch.di

import com.code.photocleanarch.data.network.PhotoApi
import com.code.photocleanarch.data.repository.PhotoRepositoryImpl
import com.code.photocleanarch.domain.repository.PhotoRepository
import com.code.photocleanarch.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object PhotoModule {

    @Provides
    fun providesPhotoApi(retrofit: Retrofit): PhotoApi {
         return retrofit
             .create(PhotoApi::class.java)
    }

    @Provides
    fun providesRetrofit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesPhotoRepository(photoApi: PhotoApi): PhotoRepository = PhotoRepositoryImpl(
        photoApi
    )
}