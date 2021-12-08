package com.amg.instagram_clone.ui.story

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.viewpager2.widget.ViewPager2
import com.amg.instagram_clone.databinding.ActivityStoryBinding

class StoryActivity : AppCompatActivity() {

    private val storyViewModel by viewModels<StoryViewModel>()
    private lateinit var binding: ActivityStoryBinding
    private val storyPagerAdapter = StoryPagerAdapter()
    private val handler = Handler(Looper.getMainLooper())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val tagName = intent.getStringExtra("tag")

        tagName?.let { storyViewModel.fetchTagGallery(it) }

        binding.storyViewPager.adapter = storyPagerAdapter
        binding.storyViewPager.registerOnPageChangeCallback(pageChangeCallBack)

        /*binding.progressView.animate()
            .scaleX(1F)
            .setDuration(3000)
            .start()*/
    }

    private val nextPageRunnable = Runnable {
        binding.storyViewPager.currentItem++
    }

    private val pageChangeCallBack = object: ViewPager2.OnPageChangeCallback(){
        override fun onPageSelected(position: Int) {
            super.onPageSelected(position)
            binding.progressView.scaleX = 0F
            binding.progressView.animate().cancel()
            binding.progressView.animate().scaleX(1F).setDuration(5000).startDelay = 10

            handler.removeCallbacks(nextPageRunnable)
            handler.postDelayed(nextPageRunnable,5000)

        }
    }

    override fun onResume() {
        super.onResume()

        storyViewModel.image.observe(this){
            storyPagerAdapter.submitList(it)
        }
    }
}