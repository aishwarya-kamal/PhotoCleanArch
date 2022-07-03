package com.code.photocleanarch.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.code.photocleanarch.R
import com.code.photocleanarch.databinding.FragmentPhotoBinding
import com.code.photocleanarch.utils.Resource
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoFragment : Fragment() {

    private val viewModel: PhotoViewModel by viewModels()
    private val adapter = PhotoAdapter()
    private lateinit var binding: FragmentPhotoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_photo, container, false)

        binding.apply {
            lifecycleOwner = viewLifecycleOwner
            recyclerView.adapter = adapter
        }

        setUpObserver()
        return binding.root
    }

    private fun setUpObserver() {
        viewModel.photos.observe(viewLifecycleOwner) {
            when(it.status) {
                Resource.Status.LOADING -> handleVisibility(View.VISIBLE, View.GONE, View.GONE)
                Resource.Status.SUCCESS -> {
                    handleVisibility(View.GONE, View.VISIBLE, View.GONE)
                    adapter.submitList(it.data)
                }
                Resource.Status.ERROR -> {
                    Snackbar.make(view!!, it.message.orEmpty(), Snackbar.LENGTH_LONG).show()
                    handleVisibility(View.GONE, View.GONE, View.VISIBLE)
                }
            }

        }
    }

    fun handleVisibility(progressBar: Int, recyclerview: Int, errorImageView: Int) {
        binding.progressBar.visibility = progressBar
        binding.recyclerView.visibility = recyclerview
        binding.errorImageView.visibility = errorImageView
    }

}