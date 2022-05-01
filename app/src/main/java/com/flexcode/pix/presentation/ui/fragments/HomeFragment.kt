package com.flexcode.pix.presentation.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.flexcode.pix.databinding.FragmentHomeBinding
import com.flexcode.pix.presentation.adapters.ImageAdapter
import com.flexcode.pix.presentation.viewModels.ImageViewModel
import com.flexcode.pix.util.Resource
import com.flexcode.pix.util.invisible
import com.flexcode.pix.util.showSnackbar
import com.flexcode.pix.util.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private  var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: ImageAdapter
    private val viewModel: ImageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        viewModel.searchQuery.value?.let { subscribeToObservers(it) }

        adapter = ImageAdapter(ImageAdapter.OnClickListener {
            //navigate to details
            val action = HomeFragmentDirections.actionHomeFragmentToImageDetailFragment(it)
            findNavController().navigate(action)
        })

        return binding.root
    }

    private fun subscribeToObservers(s: String) {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.onSearch(s.trim()).collect { image->
             when(image) {
                 is Resource.Success -> {
                     binding.imagesProgressBar.invisible()
                     binding.rvImages.visible()

                     if (image.data?.isEmpty()!!){
                         showSnackbar("Try Again")
                     }else {
                         adapter.submitList(image.data)
                         binding.rvImages.adapter = adapter
                     }
                 }
                 is Resource.Error -> {
                     binding.imagesProgressBar.visible()
                     binding.rvImages.visible()
                     showSnackbar("Error: ${image.message}")
                 }
                 is Resource.Loading -> {
                     binding.imagesProgressBar.invisible()
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