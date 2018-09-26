package com.example.farahal_kiswani.demo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.example.farahal_kiswani.demo.models.Blog.Blogs
import com.example.farahal_kiswani.demo.models.Opportunity

class BlogAdapter (var infoList: ArrayList<Blogs>) : RecyclerView.Adapter<BlogAdapter.ViewHolder>() {

    fun updateDataset(newSet: List<Blogs> ){
        infoList = newSet as ArrayList<Blogs>
        notifyDataSetChanged()
    }



    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {

        val v = LayoutInflater.from(p0.context).inflate(R.layout.blog_recycle_row, p0, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return infoList.size
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {


        p0.bindItems(infoList[p1])
    }


    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(info: Blogs) {

            val textViewName = itemView.findViewById(R.id.BlogeName) as TextView
            textViewName.text = info.title
            val  imageview = itemView.findViewById(R.id.BlogImage) as ImageView
            Glide.with(itemView.context).load(info.image).into(imageview)



        }
    }

}


