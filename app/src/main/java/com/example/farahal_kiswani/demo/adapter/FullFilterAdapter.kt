package com.example.farahal_kiswani.demo.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.farahal_kiswani.demo.R
import java.util.ArrayList

class FullFilterAdapter (val mFilterList: ArrayList<String>) : RecyclerView.Adapter<FullFilterAdapter.ViewHolder>() {
    var context: Context? = null
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.name?.text = mFilterList[p1]
        p0.card.setCardBackgroundColor(Color.parseColor("#E46300"))
//
//        when (p1) {
//            0 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#827f93"))
//            }
//            1 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#c467f4"))
//
//            }
//            2 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#3b9aee"))
//            }
//            3 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#9bc53d"))
//            }
//            4 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#f4a261"))
//            }
//            5 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#1ed2bb"))
//            }
//            6 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#778da9"))
//            }
//            7 -> {
//                p0.card.setCardBackgroundColor(Color.parseColor("#20bf55"))
//            }
//
//
//            else -> p0.card.setCardBackgroundColor(Color.parseColor("#9f9fed"))

        }




    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.single_chip, p0, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return mFilterList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.mFilterName)
        val card = itemView.findViewById<CardView>(R.id.mCardFilter)

    }
}

