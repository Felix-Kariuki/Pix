package com.flexcode.pix.feature_video.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.flexcode.pix.R
import com.flexcode.pix.databinding.VideoItemBinding
import com.flexcode.pix.feature_video.domain.model.Video

class VideoAdapter(private val onClickListener: OnClickListener) :
    ListAdapter<Video,VideoAdapter.ViewHolder>(COMPARATOR) {


    class ViewHolder(private val binding:VideoItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(video: Video?){
            Glide.with(binding.ivVideo)
                .load(video?.videos?.tiny?.url)
                .placeholder(R.drawable.ic_video)
                .into(binding.ivVideo)
            Glide.with(binding.ivVideoUserPoster)
                .load(video?.userImageURL)
                .placeholder(R.drawable.ic__person)
                .into(binding.ivVideoUserPoster)
            binding.tvUserVideo.text = video?.user
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       return ViewHolder(
           VideoItemBinding.inflate(
               LayoutInflater.from(parent.context),
               parent,
               false
           )
       )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val video = getItem(position)

        holder.bind(video)

        holder.itemView.setOnClickListener {
            onClickListener.onClick(video)
        }

    }

    companion object {
        private val COMPARATOR = object : DiffUtil.ItemCallback<Video>() {
            override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
                return oldItem.pageURL == newItem.pageURL
            }

            override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
                return oldItem == newItem
            }
        }
    }

    class OnClickListener(val clickListener: (video: Video) -> Unit) {
        fun onClick(video: Video) = clickListener(video)
    }




}