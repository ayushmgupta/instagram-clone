package com.amg.instagram_clone.ui.home

import android.annotation.SuppressLint
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.amg.instagram_clone.databinding.ListItemStoriesBinding
import com.amg.instagram_clone.ui.story.StoryActivity
import com.amg.libimgur.models.Tag

class StoriesRecyclerAdapter():
    ListAdapter<Tag, StoriesRecyclerAdapter.StoriesViewHolder>(StoriesDiffCallBack()) {
    class StoriesViewHolder(val binding: ListItemStoriesBinding):RecyclerView.ViewHolder(binding.root)

    private class StoriesDiffCallBack: DiffUtil.ItemCallback<Tag>(){
        override fun areItemsTheSame(oldItem: Tag, newItem: Tag) = (oldItem == newItem)

        @SuppressLint("DiffUtilEquals")
        override fun areContentsTheSame(oldItem: Tag, newItem: Tag) = (oldItem === newItem)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoriesViewHolder {
        val inflater = parent.context.getSystemService(LayoutInflater::class.java)
        val binding = ListItemStoriesBinding.inflate(inflater,parent,false)
        return StoriesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StoriesViewHolder, position: Int) {
        val tag = getItem(position)

        val imageUrl = "https://i.imgur.com/${tag.backgroundHash}.jpg"
        holder.binding.ivStoryProfile.load(imageUrl){
            scale(Scale.FILL
            )
        }
        Log.d("image",imageUrl)

        holder.binding.tvStoryTitle.text = tag.display_name

        holder.binding.root.apply {
            setOnClickListener {
                context.startActivity(
                    Intent(context, StoryActivity::class.java).apply {
                        putExtra("tag",tag.name)
                    }
                )
            }
        }

    }
}