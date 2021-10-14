package com.example.lonhatlong_activity_fragment_recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class NewsFragment : Fragment() {


    lateinit var homeActivity: HomeActivity
    lateinit var PhoneRecyclerView: RecyclerView
    lateinit var PhoneArrayList: ArrayList<Phone>
    lateinit var layoutManager: LinearLayoutManager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        homeActivity = activity as HomeActivity
        homeActivity.bottomNavigationView.menu.getItem(2).setChecked(true)

        setPhoneArrayList()
        PhoneRecyclerView = view.findViewById(R.id.fragmentnew_recyclerview)
        layoutManager = LinearLayoutManager(context)
        PhoneRecyclerView.layoutManager = layoutManager
        PhoneRecyclerView.setHasFixedSize(true)
        PhoneRecyclerView.adapter = AdapterPhoneRecycler(PhoneArrayList)

        return view
    }


    private fun setPhoneArrayList() {
        PhoneArrayList = ArrayList()
        PhoneArrayList.add(Phone(R.mipmap.i2390177, "ALT -3.87%", "3 Sept 2020", "ATLANTIA","Illum velit nam voluptatum enim aut.\nratione ratione officiis totam.\nMollitia eum sint tempora ducimus"))
        PhoneArrayList.add(Phone(R.mipmap.i2351087, "HKD -2.13%", "2 Sept 2020", "XIAOMI","Illum velit nam voluptatum enim aut.\nratione ratione officiis totam.\nMollitia eum sint tempora ducimus"))
        PhoneArrayList.add(Phone(R.mipmap.i2390177, "AAPL -0.91%", "1 Sept 2020", "APPLE","Illum velit nam voluptatum enim aut.\nratione ratione officiis totam.\nMollitia eum sint tempora ducimus"))
    }

}