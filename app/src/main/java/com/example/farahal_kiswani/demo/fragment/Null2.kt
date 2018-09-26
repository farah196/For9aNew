package com.example.farahal_kiswani.demo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import com.example.farahal_kiswani.demo.R


class Null2 : Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.todo_layout, null)





        return v

    }

    companion object {


        fun getInstance(): Null2 {

            val obj = Null2()



            return obj

        }
    }

}