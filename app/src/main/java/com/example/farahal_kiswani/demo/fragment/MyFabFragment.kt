
package com.example.farahal_kiswani.demo.fragment

import android.app.Dialog
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v4.util.ArrayMap
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.DisplayMetrics
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import com.allattentionhere.fabulousfilter.AAH_FabulousFragment
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.R.id.mFilterListLayout
import com.example.farahal_kiswani.demo.activity.MainActivity
import com.example.farahal_kiswani.demo.adapter.CategoryFilterAdapter
import com.example.farahal_kiswani.demo.adapter.FullFilterAdapter


import com.google.android.flexbox.FlexboxLayout
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_filters_sorters.*
import java.util.ArrayList

class MyFabFragment : AAH_FabulousFragment() {


     var textviews: MutableList<TextView> = ArrayList()

     var tabs_types: TabLayout?=null

     var imgbtn_refresh: ImageButton?=null
     var imgbtn_apply:ImageButton?=null
     var mAdapter: SectionsPagerAdapter?=null
    private var metrics: DisplayMetrics? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        metrics = this.resources.displayMetrics
    }


    override fun setupDialog(dialog: Dialog, style: Int) {
        val contentView = View.inflate(context, R.layout.filter_view, null)

        val rl_content = contentView.findViewById<View>(R.id.rl_content) as RelativeLayout
        val ll_buttons = contentView.findViewById<View>(R.id.ll_buttons) as LinearLayout
        imgbtn_refresh = contentView.findViewById<View>(R.id.imgbtn_refresh) as ImageButton
        imgbtn_apply = contentView.findViewById<View>(R.id.imgbtn_apply) as ImageButton
        val vp_types = contentView.findViewById<View>(R.id.vp_types) as ViewPager
        tabs_types = contentView.findViewById<View>(R.id.tabs_types) as TabLayout

//        imgbtn_apply!!.setOnClickListener { closeFilter(applied_filters) }
//        imgbtn_refresh!!.setOnClickListener {
//            for (tv in textviews) {
//                tv.tag = "unselected"
//                tv.setBackgroundResource(R.drawable.chip_unselected)
//                tv.setTextColor(ContextCompat.getColor(context!!, R.color.filters_chips))
//            }
//            applied_filters!!.clear()
//        }

        mAdapter = SectionsPagerAdapter()
        vp_types.offscreenPageLimit = 3
        vp_types.adapter = mAdapter
        mAdapter!!.notifyDataSetChanged()
        tabs_types!!.setupWithViewPager(vp_types)

       // imgbtn_apply!!.setOnClickListener { closeFilter(0) }
        //params to set
        setAnimationDuration(400) //optional; default 500ms
        setPeekHeight(300) // optional; default 400dp
        setCallbacks(activity as AAH_FabulousFragment.Callbacks?) //optional; to get back result
        setAnimationListener(activity as AAH_FabulousFragment.AnimationListener?) //optional; to get animation callbacks
        setViewgroupStatic(ll_buttons) // optional; layout to stick at bottom on slide
        setViewPager(vp_types) //optional; if you use viewpager that has scrollview
        setViewMain(rl_content) //necessary; main bottomsheet view
        setMainContentView(contentView) // necessary; call at end before super
        super.setupDialog(dialog, style) //call super at last

    }


    inner class SectionsPagerAdapter : PagerAdapter() {


        override fun instantiateItem(collection: ViewGroup, position: Int): Any {
            val inflater = LayoutInflater.from(context)
            val layout = inflater.inflate(R.layout.view_filters_sorters, collection, false) as ViewGroup
            var recycler = layout.findViewById(R.id.mFilterListLayout) as RecyclerView
            recycler.layoutManager = GridLayoutManager(context,3, LinearLayout.VERTICAL, false) as RecyclerView.LayoutManager?
            val mFilterList = ArrayList<String>()
            mFilterList.add("تبادل ثقافي")
            mFilterList.add("فرص عمل")
            mFilterList.add("فرص تعليم")
            mFilterList.add("منحة مالية")
            mFilterList.add("منحة دراسية")
            mFilterList.add("جوائز ومسابقات")
            mFilterList.add("فرص إقامة")
            mFilterList.add(" دورات عبر الإنترنت")
            recycler.adapter = FullFilterAdapter(mFilterList)


            collection.addView(layout)
            return layout

        }

        override fun destroyItem(collection: ViewGroup, position: Int, view: Any) {
            collection.removeView(view as View)
        }



        override fun getPageTitle(position: Int): CharSequence? {
            when (position) {
                0 -> return "التخصص"
                1 -> return "الفئة"
                2 -> return "الدول"

            }
            return ""
        }



        override fun isViewFromObject(p0: View, p1: Any): Boolean {
            return p0==p1
        }

        override fun getCount(): Int {
            return 3
        }

    }



    companion object {
        fun newInstance(): MyFabFragment {
            return MyFabFragment()

        }
    }
}