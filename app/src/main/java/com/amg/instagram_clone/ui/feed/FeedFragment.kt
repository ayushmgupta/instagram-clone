package com.amg.instagram_clone.ui.feed

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.amg.instagram_clone.databinding.FeedFragmentBinding

class FeedFragment : Fragment() {

    companion object {
        fun newInstance() = FeedFragment()
    }

    private val viewModel: FeedViewModel by viewModels()
    private var feedRecyclerAdapter = FeedRecyclerAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val feed = arguments?.getString("feed")
        feed?.let { viewModel.updateFeed(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //val feed = arguments?.getString("feed")
        val binding = FeedFragmentBinding.inflate(inflater,container,false)

        //feed?.let { binding.tvText.text = feed }

        binding.rvFeed.layoutManager = LinearLayoutManager(requireContext())
        binding.rvFeed.adapter = feedRecyclerAdapter


        viewModel.feed.observe({lifecycle}){
            feedRecyclerAdapter.submitList(it)
        }

        return binding.root
    }


}