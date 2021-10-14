package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lonhatlong_activity_fragment_recycler.OnBoardingActivity
import com.example.lonhatlong_activity_fragment_recycler.R

class FragmentOnboarding3 : Fragment() {

    lateinit var onBoardingActivity: OnBoardingActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onboarding3, container, false)
        onBoardingActivity = activity as OnBoardingActivity
        val btStart: TextView = view.findViewById(R.id.tv_onboad3_start)
        val imgBack: ImageView = view.findViewById(R.id.img_onboarding3_back)
        val tvSkip: TextView = view.findViewById(R.id.tv_boarding3_skip)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)
        btStart.setOnClickListener {
            val editor : SharedPreferences.Editor = onBoardingActivity.sharedPreferences.edit()
            editor.putBoolean("firsttime", false)
            editor.commit()
            findNavController().navigate(R.id.action_viewPagerFragment_to_fragmentLogin)
        }
        imgBack.setOnClickListener {
            viewPager?.currentItem = 1
        }
        tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_fragmentLogin)
        }
        return view
    }
}