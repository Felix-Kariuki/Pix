package com.flexcode.pix.feature_video.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.flexcode.pix.databinding.FragmentVideosBinding
import com.flexcode.pix.feature_video.presentation.adapters.VideoAdapter
import com.flexcode.pix.feature_video.presentation.viewModels.VideoViewModel
import com.flexcode.pix.core.util.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideosFragment : Fragment() {

    private var _binding: FragmentVideosBinding? = null
    private val binding get() = _binding!!
    private val viewModel: VideoViewModel by viewModels()
    private lateinit var videoAdapter: VideoAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentVideosBinding.inflate(inflater,container,false)

        videoAdapter = VideoAdapter(VideoAdapter.OnClickListener {
            val action = VideosFragmentDirections.actionVideosFragmentToVideoDetailsFragment(it)
            findNavController().navigate(action)
        })

        binding.videoSearchView.setEndIconOnClickListener {
            //TODO : Search Videos
        }

        viewModel.searchQuery.value?.let { subscribeToObservers(it) }

        return binding.root
    }

    private fun subscribeToObservers(s: String) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.onSearch(s.trim()).collect { video->
                when(video) {
                    is Resource.Success -> {
                        binding.videosProgressBar.visibility = View.GONE
                        binding.rvVideos.visibility = View.VISIBLE

                        if (video.data?.isEmpty()!!){
                            showSnackbar("Try Again")
                        }else {
                            videoAdapter.submitList(video.data)
                            binding.rvVideos.adapter = videoAdapter
                        }
                    }
                    is Resource.Error -> {
                        binding.videosProgressBar.visibility = View.VISIBLE
                        binding.rvVideos.visibility = View.VISIBLE
                        showSnackbar("Error: ${video.message}")
                    }
                    is Resource.Loading -> {
                        binding.videosProgressBar.visibility = View.GONE
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