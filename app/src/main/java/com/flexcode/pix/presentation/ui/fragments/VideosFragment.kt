package com.flexcode.pix.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.flexcode.pix.R
import com.flexcode.pix.databinding.FragmentVideosBinding
import com.flexcode.pix.presentation.viewModels.ImageViewModel
import com.flexcode.pix.presentation.viewModels.VideoViewModel
import com.flexcode.pix.util.Resource
import com.flexcode.pix.util.invisible
import com.flexcode.pix.util.showSnackbar
import com.flexcode.pix.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VideoViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVideosBinding.inflate(inflater,container,false)


        viewModel.searchQuery.value?.let { subscribeToObservers(it) }

        return binding.root
    }

    private fun subscribeToObservers(s: String) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.onSearch(s.trim()).collect { image->
                when(image) {
                    is Resource.Success -> {
                        showSnackbar("success")

                        if (image.data?.isEmpty()!!){
                            showSnackbar("Try Again")
                        }else {
                            showSnackbar("success")
                        }
                    }
                    is Resource.Error -> {
                        showSnackbar("Error: ${image.message}")
                    }
                    is Resource.Loading -> {
                    }
                }
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}