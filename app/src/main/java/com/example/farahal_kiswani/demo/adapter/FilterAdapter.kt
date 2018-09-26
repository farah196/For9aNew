package com.example.farahal_kiswani.demo.adapter

import android.content.Context
import android.graphics.Color
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.demo.R
import java.util.*
import android.widget.Toast
import android.widget.CheckBox
import android.widget.TextView
import net.igenius.customcheckbox.CustomCheckBox


class FilterAdapter(val mFilterList: ArrayList<String>) : RecyclerView.Adapter<FilterAdapter.ViewHolder>() {
    var context: Context? = null
    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        p0.name.text = mFilterList[p1]


   //    p0.check.setChecked(false,true)



    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
        val v = LayoutInflater.from(p0?.context).inflate(R.layout.filter_row, p0, false)
        return ViewHolder(v)
    }


    override fun getItemCount(): Int {
        return mFilterList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val name: TextView = itemView.findViewById<TextView>(R.id.mFilterSort)
     //   val check: CustomCheckBox = itemView.findViewById<CustomCheckBox>(R.id.mChkSelected)
    }
}
