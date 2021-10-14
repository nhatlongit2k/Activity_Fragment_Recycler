package com.example.lonhatlong_activity_fragment_recycler.onboarding.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lonhatlong_activity_fragment_recycler.R

class FragmentOnborading1 : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_onborading1, container, false)
        val btNext: TextView = view.findViewById(R.id.tv_onboad1_next)
        val tvSkip: TextView = view.findViewById(R.id.tv_boarding1_skip)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.view_pager)

        tvSkip.setOnClickListener {
            findNavController().navigate(R.id.action_viewPagerFragment_to_fragmentLogin)
        }
        btNext.setOnClickListener{
            viewPager?.currentItem = 1
        }
        return view
    }

}