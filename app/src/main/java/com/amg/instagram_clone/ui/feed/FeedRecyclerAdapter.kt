package com.amg.instagram_clone.ui.feed

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.amg.instagram_clone.R
import com.amg.instagram_clone.databinding.ListItemGalleryImageBinding
import com.amg.libimgur.models.Image

class FeedRecyclerAdapter() :
    androidx.recyclerview.widget.ListAdapter<Image, FeedRecyclerAdapter.FeedViewHolder>(FeedDiffCallBack()) {

    class FeedViewHolder(val binding: ListItemGalleryImageBinding) :
        RecyclerView.ViewHolder(binding.root){

    }

    private class FeedDiffCallBack : DiffUtil.ItemCallback<Image>() {
        override fun areItemsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: Image, newItem: Image): Boolean {
            return oldItem.toString() == newItem.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeedViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemGalleryImageBinding.inflate(inflater,parent,false)
        return FeedViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FeedViewHolder, position: Int) {

        val image = getItem(position)

        holder.binding.textView.text = getItem(position).title
        holder.binding.imageView.load("https://imgur.com/${image.cover}.jpg"){
            placeholder(R.drawable.placeholder)
            error(R.drawable.no_image_placeholder)
        }

        holder.binding.ivProfile.load("https://imgur.com/${image.cover}.jpg"){
            placeholder(R.drawable.placeholder)
            error(R.drawable.no_image_placeholder)
        }
        Log.d("cover","${image.cover}")


        holder.binding.tvProfile.text = image.account_url
        holder.binding.tvComments.text = image.comment_count.toString()
        holder.binding.tvLikes.text = image.favorite_count.toString()
    }


}