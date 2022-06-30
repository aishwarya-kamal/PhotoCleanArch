package com.code.photocleanarch.di

import com.code.photocleanarch.data.network.PhotoApi
import com.code.photocleanarch.utils.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import retrofit2.Retrofit

@Module
@InstallIn
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
            .build()
    }
}