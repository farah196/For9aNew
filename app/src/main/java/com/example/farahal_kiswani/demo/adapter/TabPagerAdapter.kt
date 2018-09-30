package com.example.farahal_kiswani.demo.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.farahal_kiswani.demo.fragment.Home
import com.example.farahal_kiswani.demo.Learn

class TabPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    //returns the Fragments to be loaded inside the ViewPager
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                Home.newInstance()
            }
            1 -> {
               Learn.newInstance()


            }
            else -> Home.newInstance()
        }
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        when (position) {
            0 -> return "فرص"
            1 -> return "تعلم"

        }
        return null
    }



}