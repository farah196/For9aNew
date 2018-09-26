package com.example.farahal_kiswani.demo.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.fragment.*
import com.example.farahal_kiswani.demo.util.ViewFindUtils
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.filter_activity.*


class Filter : AppCompatActivity(), OnTabSelectListener {
    private val mContext = this

    private val mSpecialities = ArrayList<Fragment>()
    private val mCategory = ArrayList<Fragment>()
    private val mCountries = ArrayList<Fragment>()
    private val mTitles = arrayOf(

             "الدول", "الفئة", "التخصص")

    private var mAdapter: FilterAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filter_activity)
        setSupportActionBar(findViewById<View>(R.id.toolbar) as Toolbar)
        initActionBar()


        for (item in mTitles) {


            mSpecialities.add(Specialities.getInstance())
            mCategory.add(Category.getInstance())
            mCountries.add(Countries.getInstance())


        }




        val decorView = window.decorView

        val vp = ViewFindUtils().find<ViewPager>(decorView, R.id.viewpager_filter)

        mAdapter = FilterAdapter(supportFragmentManager)

        vp!!.setAdapter(mAdapter)
        tabs_filter.setViewPager(vp)
        tabs_filter.setOnTabSelectListener(this)


        tabs_filter.setMsgMargin(3, 0.0F, 10F)
        vp.setCurrentItem(1)
    }


    override fun onTabSelect(position: Int) {

        Toast.makeText(mContext, "onTabSelect&position--->$position", Toast.LENGTH_SHORT).show()

    }


    override fun onTabReselect(position: Int) {

        Toast.makeText(mContext, "onTabReselect&position--->$position", Toast.LENGTH_SHORT).show()

    }


    private inner class FilterAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


        override fun getCount(): Int {

            return mSpecialities.size

        }


        override fun getPageTitle(position: Int): CharSequence? {

            return mTitles[position]

        }


        override fun getItem(position: Int): Fragment {

            return mSpecialities[position]

        }





    }

    private fun initActionBar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }



        }
        return super.onOptionsItemSelected(item)
    }
}