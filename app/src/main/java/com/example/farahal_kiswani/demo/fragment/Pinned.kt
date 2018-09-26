package com.example.farahal_kiswani.demo.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.farahal_kiswani.demo.R
import android.widget.TextView


public class Pinned : Fragment() {




    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.pinned_fragment, null)




        return v

    }

    companion object {


        fun getInstance(): Pinned {

            val obj = Pinned()



            return obj

        }
    }

}