package com.example.lonhatlong_activity_fragment_recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class MenuFragment : Fragment() {
    lateinit var homeActivity: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_menu, container, false)
        homeActivity = activity as HomeActivity
        homeActivity.bottomNavigationView.menu.getItem(3).setChecked(true)
        return view
    }
}