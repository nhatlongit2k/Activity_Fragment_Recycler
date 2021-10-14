package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lonhatlong_activity_fragment_recycler.R

class FragmentOnboarding2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding2, container, false)
        val btNext: TextView = view.findViewById(R.id.tv_onboad2_next)
        val tvSkip : TextView = view.findViewById(R.id.tv_boarding2_skip)
        val imgBack: ImageView = view.findViewById(R.id.img_onboarding2_back)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        btNext.setOnClickListener{
            viewPager?.currentItem = 2
        }
        imgBack.setOnClickListener {
            viewPager?.currentItem = 0
        }
        tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_fragmentLogin)
        }
        return view
    }
}