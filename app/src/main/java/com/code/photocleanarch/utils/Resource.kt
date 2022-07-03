package com.code.photocleanarch.utils

import com.code.photocleanarch.utils.Resource.Status.*

data class Resource<out T>(
    val status: Status,
    val data: T?,
    val message: String?,
) {

    enum class Status {
         LOADING, SUCCESS, ERROR,
    }

    companion object {
        fun <T> loading(): Resource<T> {
            return Resource(LOADING, null, null)
        }

        fun <T> success(data: T): Resource<T> {
            return Resource(SUCCESS, data, null)
        }

        fun <T> error(message: String): Resource<T> {
            return Resource(ERROR, null, message)
        }
    }
}
