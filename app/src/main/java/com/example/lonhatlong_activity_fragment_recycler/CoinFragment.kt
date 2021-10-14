package com.example.lonhatlong_activity_fragment_recycler

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.NumberFormat
import kotlin.random.Random


class CoinFragment : Fragment() {
    lateinit var homeActivity: HomeActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_coin, container, false)
        homeActivity = activity as HomeActivity
        homeActivity.bottomNavigationView.menu.getItem(1).setChecked(true)
        if(arguments != null){
            val tradix: Tradix = arguments?.getSerializable("data") as Tradix
            val tv_name: TextView = view.findViewById(R.id.fragmentcoin_name)
            val tv_money: TextView = view.findViewById(R.id.fragmentcoin_money)
            val tv_time: TextView = view.findViewById(R.id.fragmentcoin_time)
            val tv_growth: TextView = view.findViewById(R.id.fragmentcoin_growth)
            tv_name.setText(tradix.name)
            val numberFormat = NumberFormat.getCurrencyInstance()
            numberFormat.setMaximumFractionDigits(0);
            val convert = numberFormat.format(tradix.money)
            tv_money.setText(convert)
            tv_time.setText(tradix.time + "Real time")
            tv_growth.setText(tradix.growth)
        }

        return view
    }
}