package com.example.lonhatlong_activity_fragment_recycler

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class AdapterPhoneRecycler(var PhoneList: ArrayList<Phone>): RecyclerView.Adapter<AdapterPhoneRecycler.PhoneViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.phone_list, parent, false)
        return PhoneViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PhoneViewHolder, position: Int) {
        val currentItem = PhoneList[position]
        holder.imgPhone.setImageResource(currentItem.img)
        holder.alt.setText(currentItem.alt)
        holder.date.setText(currentItem.date)
        holder.name.setText(currentItem.name)
        holder.decryption.setText(currentItem.decryption)

        holder.itemView.setOnClickListener {
            val activity : AppCompatActivity = it.context as AppCompatActivity
            val newArticleFragment = NewsArticleFragment()
            val bundle = Bundle()
            bundle.putSerializable("dataToNewsArticleFragment", currentItem)
            newArticleFragment.arguments = bundle
            activity.supportFragmentManager.beginTransaction().replace(R.id.homeActivity_fragmentContainerView,newArticleFragment).addToBackStack("NewsArticleFragment").commit()
        }
    }

    override fun getItemCount(): Int {
        return PhoneList.size
    }
    inner class PhoneViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imgPhone: ImageView = itemView.findViewById(R.id.phone_img)
        val alt: TextView = itemView.findViewById(R.id.phone_alt)
        val date: TextView = itemView.findViewById(R.id.phone_date)
        val name: TextView = itemView.findViewById(R.id.phone_name)
        val decryption: TextView = itemView.findViewById(R.id.phone_decryption)
    }
}