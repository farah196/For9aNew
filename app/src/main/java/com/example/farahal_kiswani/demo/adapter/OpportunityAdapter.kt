package com.example.farahal_kiswani.demo.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.models.Opportunity


class OpportunityAdapter(var infoList: ArrayList<Opportunity>) : RecyclerView.Adapter<OpportunityAdapter.ViewHolder>(){


    var context: Context? = null
    var isGrid = false
    private val VIEW_TYPE_GRID = 0
    private val VIEW_TYPE_LIST = 1


    fun updateDataset(newSet: List<Opportunity>) {
        infoList = newSet as ArrayList<Opportunity>
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val v = LayoutInflater.from(p0.context).inflate(R.layout.activity_recycler_row, p0, false)
               return ViewHolder(v)


//        return when (p1) {
//            VIEW_TYPE_GRID -> {
//                val v = LayoutInflater.from(p0.context).inflate(R.layout.activity_recycler_row, p0, false)
//                return ViewHolder(v)
//            }
//            VIEW_TYPE_LIST -> {
//                val v = LayoutInflater.from(p0.context).inflate(R.layout.activity_recycler_row, p0, false)
//                return ViewHolder(v)
//
//
//            }
//
//
//            else -> {
//                val v = LayoutInflater.from(p0.context).inflate(R.layout.activity_recycler_row, p0, false)
//                return ViewHolder(v)
//            }
//
//
//        }

    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {

        p0.bindItems(infoList[p1])

    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(info: Opportunity) {

            val textViewName = itemView.findViewById(R.id.textViewUsername) as TextView
            textViewName.text = info.name
            val imageview = itemView.findViewById(R.id.imageView) as ImageView
            Glide.with(itemView.context).load(info.image.mi).into(imageview)
            val textViewOrg = itemView.findViewById(R.id.mOrganization_name) as TextView
            textViewOrg.text = info.organization.name_ar
            val imageviewOrg = itemView.findViewById(R.id.mImageOrg) as ImageView
            Glide.with(itemView.context).load(info.organization.profile_pic).into(imageviewOrg)

        }
    }

}


