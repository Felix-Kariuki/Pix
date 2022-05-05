package com.flexcode.pix.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.flexcode.pix.R
import com.flexcode.pix.databinding.FragmentImageDetailBinding
import com.flexcode.pix.presentation.viewModels.ImageDetailsViewModel
import com.google.android.material.chip.Chip
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ImageDetailFragment : Fragment() {


    private var _binding: FragmentImageDetailBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ImageDetailsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentImageDetailBinding.inflate(inflater,container,false)

        binding.ivDetailBack.setOnClickListener { findNavController().popBackStack() }

        viewModel.imageDetails.observe(viewLifecycleOwner) { image ->
            binding.tvUserId.text = image?.userId.toString()
            binding.tvUser.text = image?.user
            Glide.with(binding.ivUserImageUrl)
                .load(image?.userImageURL)
                .placeholder(R.drawable.ic__person)
                .into(binding.ivUserImageUrl)

            Glide.with(binding.ivDetailImage)
                .load(image?.webformatURL)
                .placeholder(R.drawable.ic_image)
                .into(binding.ivDetailImage)
            binding.tvLikes.text = image?.likes.toString()
            binding.tvDetailComments.text = image?.comments.toString()
            binding.tvDownloads.text = image?.downloads.toString()
            binding.tvViews.text = image?.views.toString()

            val tags = stringToList(image!!.tags)
            tags.forEach { tag->
                val tagItem = LayoutInflater.from(requireContext())
                    .inflate(R.layout.tag_item,null,false)
                as Chip
                tagItem.apply { text = tag }
                binding.tagsChipGroup.addView(tagItem)
            }
        }

        return binding.root
    }

    private fun stringToList(string: String): List<String> =
        string.trim().splitToSequence(", ")
            .filter { it.isNotEmpty() }
            .toList()

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}