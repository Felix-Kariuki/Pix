package com.flexcode.pix.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flexcode.pix.R
import com.flexcode.pix.databinding.ImageItemBinding
import com.flexcode.pix.domain.model.Image

class ImageAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Image, ImageAdapter.MyViewHolder>(COMPARATOR) {

    inner class MyViewHolder(private val binding: ImageItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(image: Image?) {
            Glide.with(binding.ivImage)
                .load(image?.webformatURL)
                .placeholder(R.drawable.ic_launcher_background)
                .into(binding.ivImage)
            binding.tvUserName.text = image?.user
            binding.tvLikes.text = image?.likes.toString()
            binding.tvComments.text = image?.comments.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            ImageItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val image = getItem(position)
        holder.bind(image)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(image)
        }
    }




    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Image>() {
            override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem.previewURL == newItem.previewURL
            }

            override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
                return oldItem == newItem
            }
        }
    }

    class OnClickListener(val clickListener: (image: Image) -> Unit) {
        fun onClick(image: Image) = clickListener(image)
    }
}