package com.example.lonhatlong_activity_fragment_recycler.onboarding

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.lonhatlong_activity_fragment_recycler.OnBoardingActivity
import com.example.lonhatlong_activity_fragment_recycler.R
import com.example.lonhatlong_activity_fragment_recycler.onboarding.screen.FragmentOnboarding2
import com.example.lonhatlong_activity_fragment_recycler.onboarding.screen.FragmentOnboarding3
import com.example.lonhatlong_activity_fragment_recycler.onboarding.screen.FragmentOnborading1

class ViewPagerFragment : Fragment() {

    lateinit var onBoardingActivity: OnBoardingActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)
        onBoardingActivity = activity as OnBoardingActivity
        val firstTime: Boolean = onBoardingActivity.sharedPreferences.getBoolean("firsttime",true)
        Log.d("TAG", "onCreateView: $firstTime")

        if(firstTime==false){
            findNavController().navigate(R.id.action_viewPagerFragment_to_fragmentLogin)
        }else{
            val fragmentList = arrayListOf<Fragment>(
                FragmentOnborading1(),
                FragmentOnboarding2(),
                FragmentOnboarding3()
            )
            val viewPager : ViewPager2 = view.findViewById(R.id.view_pager)
            val adapter = ViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
            )
            viewPager.adapter = adapter
        }
        return view
    }
    private fun onBoardingFinished(): Boolean{

        val prefs : SharedPreferences = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return prefs.getBoolean("firstStart", true)

//        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
//        return sharedPref.getBoolean("Finíhed", false)
    }

}