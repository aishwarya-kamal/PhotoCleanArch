package com.code.photocleanarch.data

import com.code.photocleanarch.data.model.PhotoRemote
import com.code.photocleanarch.domain.model.Photo

fun PhotoRemote.toPhoto(): Photo = Photo(
    id = id,
    title = title,
    url = url,
    thumbnailUrl = thumbnailUrl
)