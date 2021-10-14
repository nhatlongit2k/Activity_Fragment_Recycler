package com.example.lonhatlong_activity_fragment_recycler

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import java.math.RoundingMode
import java.text.DecimalFormat

class AdapterTradixRecycler(val tradixList: ArrayList<Tradix>, val context: Context?): RecyclerView.Adapter<AdapterTradixRecycler.TraxdixViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TraxdixViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return TraxdixViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: TraxdixViewHolder, position: Int) {
        val currentItem =tradixList[position]
        holder.tvName.setText(currentItem.name)
        val dec = DecimalFormat("#,###,##")
        dec.roundingMode = RoundingMode.CEILING
        holder.tvMoney.setText(dec.format(currentItem.money).toString())
        holder.tvCity.setText(currentItem.city)
        holder.tvTime.setText(currentItem.time)
        holder.tvGrowth.setText(currentItem.growth)
        holder.itemView.setOnClickListener {
            val activity : AppCompatActivity = it.context as AppCompatActivity
            val coinFragment = CoinFragment()
            val bundle = Bundle()
            bundle.putSerializable("data", currentItem)
            coinFragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.homeActivity_fragmentContainerView,coinFragment).addToBackStack("CoinFragment").commit()
        }
    }

    override fun getItemCount(): Int {
        return tradixList.size
    }

    inner class TraxdixViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val tvName: TextView = itemView.findViewById(R.id.item_name)
        val tvMoney: TextView = itemView.findViewById(R.id.item_money)
        val tvCity: TextView = itemView.findViewById(R.id.item_contry)
        val tvTime: TextView = itemView.findViewById(R.id.item_time)
        val tvGrowth: TextView = itemView.findViewById(R.id.item_growth)
    }
}

