package com.example.farahal_kiswani.demo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.adapter.FilterAdapter

class Specialities : Fragment() {


    val mList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.specialities_fragment, null)
        var recycler = v.findViewById(R.id.mRecyclerFilter) as RecyclerView
        recycler.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        recycler.adapter = FilterAdapter(mList)




        mList.add("تبادل ثقافي")
        mList.add("فرص عمل")
        mList.add("فرص تعليم")
        mList.add("منحة مالية")
        mList.add("منحة دراسية")
        mList.add("جوائز ومسابقات")
        mList.add("فرص إقامة")
        mList.add(" دورات عبر الإنترنت")

        return v

    }


    companion object {


        fun getInstance(): Specialities {

            val obj = Specialities()



            return obj

        }
    }


}