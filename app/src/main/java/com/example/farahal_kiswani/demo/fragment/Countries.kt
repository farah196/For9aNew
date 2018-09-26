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

class Countries : Fragment() {


    val mList = ArrayList<String>()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.countries_fragment, null)


        return v

    }


    companion object {


        fun getInstance(): Countries {

            val obj = Countries()



            return obj

        }
    }


}