package com.flexcode.pix.feature_video.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.flexcode.pix.databinding.FragmentVideoDetailsBinding
import com.flexcode.pix.feature_image.presentation.viewmodel.ImageDetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class VideoDetailsFragment : Fragment() {

    private var _binding: FragmentVideoDetailsBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ImageDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentVideoDetailsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.videoDetails.observe(viewLifecycleOwner) {
            val mediaController = MediaController(requireContext())
            mediaController.setAnchorView(binding.ivVideoView)
            binding.ivVideoView.apply {
                setVideoPath(it?.videos?.medium?.url)
                start()
                setMediaController(mediaController)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}