package com.amg.instagram_clone.ui.story

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.amg.instagram_clone.databinding.PageItemStoryBinding
import com.amg.libimgur.models.Image

class StoryPagerAdapter() :
    ListAdapter<Image, StoryPagerAdapter.StoryPagerViewHolder>(StoryDiffCallBack()) {
    class StoryPagerViewHolder(val binding: PageItemStoryBinding):RecyclerView.ViewHolder(binding.root){}

    class StoryDiffCallBack(): DiffUtil.ItemCallback<Image>(){
        override fun areItemsTheSame(oldItem: Image, newItem: Image) = (oldItem == newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Image, newItem: Image) = (oldItem === newItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryPagerViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = PageItemStoryBinding.inflate(inflater,parent,false)
        return StoryPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoryPagerViewHolder, position: Int) {
        val image = getItem(position)

        val imageUrl = if (image?.is_album == true && image.images_count != 0){
            image.images!![0].link!!
        }else{
            image.link
        }

        imageUrl?.let {
            holder.binding.ivStory.load(imageUrl)
            holder.binding.tvImage.text = imageUrl

        }

    }
}