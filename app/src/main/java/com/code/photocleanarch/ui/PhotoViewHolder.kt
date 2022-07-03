package com.code.photocleanarch.ui

import androidx.recyclerview.widget.RecyclerView
import com.code.photocleanarch.databinding.ListItemPhotoBinding
import com.code.photocleanarch.domain.model.Photo

class PhotoViewHolder(
    private val binding: ListItemPhotoBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) {
        binding.apply {
            this.photo = photo
            executePendingBindings()
        }
    }

}