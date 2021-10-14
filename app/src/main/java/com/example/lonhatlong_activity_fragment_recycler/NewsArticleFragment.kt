package com.example.lonhatlong_activity_fragment_recycler

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class NewsArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_news_article, container, false)
        if(arguments != null){
            val phone: Phone = arguments?.getSerializable("dataToNewsArticleFragment") as Phone
            val tv_name: TextView = view.findViewById(R.id.fragmentnewarticle_title)
            val tv_date: TextView = view.findViewById(R.id.fragmentnewarticle_date)
            tv_name.setText(phone.name)
            tv_date.setText(phone.date)
        }
        return view
    }
}