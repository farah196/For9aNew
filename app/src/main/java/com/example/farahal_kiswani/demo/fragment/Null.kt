package com.example.farahal_kiswani.demo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.demo.R


class Null :Fragment() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.todo_layout, null)

        return v

    }



    companion object {


        fun getInstance(): Null {

            val obj = Null()



            return obj

        }
    }



}