package com.example.farahal_kiswani.demo.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.farahal_kiswani.demo.R
import android.graphics.Color.parseColor
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.support.v7.widget.CardView
import android.widget.TextView
import java.util.*


class CategoryFilterAdapter(val mFilterList: ArrayList<String>) : RecyclerView.Adapter<CategoryFilterAdapter.ViewHolder>() {
    var context: Context? = null
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0?.name?.text = mFilterList[p1]

//        val layerDrawable =  p0?.button.getBackground().getCurrent() as LayerDrawable
//        val gradientDrawable = layerDrawable.findDrawableByLayerId(R.id.shape_background).current as GradientDrawable
//// set you color based on position
//        gradientDrawable.setColor(Color.parseColor("#ff22ff"))
//

//        val mRandom = Random()
//        val colors: MutableList<String>
//
//        colors = ArrayList()
//
//        colors.add("#827f93")
//        colors.add("#c467f4")
//        colors.add("#3b9aee")
//        colors.add("#9bc53d")
//        colors.add("#f4a261")
//        colors.add("#1ed2bb")
//        colors.add("#778da9")
//        colors.add("#20bf55")
//        colors.add("#9f9fed")
//        colors.add("#fc6177")
//        colors.add("#bcbcbc")
//
//
//        val position = mRandom.nextInt(11 - 0) + 0
//        p0.card.setCardBackgroundColor(Color.parseColor(colors.get(position)))
         when (p1) {
            0 -> {
                p0.card.setCardBackgroundColor(Color.parseColor("#827f93"))
            }
            1 -> {
                p0.card.setCardBackgroundColor(Color.parseColor("#c467f4"))

            }
            2 -> {
                p0.card.setCardBackgroundColor(Color.parseColor("#3b9aee"))
            }
             3 -> {
                 p0.card.setCardBackgroundColor(Color.parseColor("#9bc53d"))
             }
             4 -> {
                 p0.card.setCardBackgroundColor(Color.parseColor("#f4a261"))
             }
             5 -> {
                 p0.card.setCardBackgroundColor(Color.parseColor("#1ed2bb"))
             }
             6 -> {
                 p0.card.setCardBackgroundColor(Color.parseColor("#778da9"))
             }
             7 -> {
                 p0.card.setCardBackgroundColor(Color.parseColor("#20bf55"))
             }


            else ->  p0.card.setCardBackgroundColor(Color.parseColor("#9f9fed"))

        }




    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.filter_recycler_row, p0, false)
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