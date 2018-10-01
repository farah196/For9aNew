package com.example.farahal_kiswani.demo.activity

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.support.v4.view.GravityCompat
import android.support.v4.view.ViewPager
import android.support.v7.app.ActionBar
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.util.Log

import android.view.View
import android.view.Window
import android.widget.*
import com.allattentionhere.fabulousfilter.AAH_FabulousFragment
import com.example.farahal_kiswani.demo.ApiService
import com.example.farahal_kiswani.demo.adapter.OpportunityAdapter
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.adapter.CategoryFilterAdapter
import com.example.farahal_kiswani.demo.adapter.TabPagerAdapter
import com.example.farahal_kiswani.demo.controller.ActivityCallBack
import com.example.farahal_kiswani.demo.fragment.MyFabFragment
import kotlinx.android.synthetic.main.activity_main.*
import com.example.farahal_kiswani.demo.models.Opportunity
import com.example.farahal_kiswani.demo.models.TimelineResponse2
import com.example.farahal_kiswani.demo.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), ActivityCallBack, AAH_FabulousFragment.Callbacks, AAH_FabulousFragment.AnimationListener {
    override fun onResult(result: Any?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    var dialogFrag: MyFabFragment? = null
    var dialogFrag1: MyFabFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)


        dialogFrag1 = MyFabFragment.newInstance()
        dialogFrag1!!.setParentFab(mFabButton1)
        mFabButton1.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        dialogFrag1!!.show(getSupportFragmentManager(), dialogFrag1!!.getTag())
                    }
                })



        setViewPagerAdapter()
        setCategoryFilter()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)

        val actionBar: ActionBar? = supportActionBar
        actionBar!!.setDisplayHomeAsUpEnabled(true)
        val mDrawerToggle: ActionBarDrawerToggle?


        mDrawerToggle = object : ActionBarDrawerToggle(this, drawer_layout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            override fun onDrawerClosed(view: View) {
                super.onDrawerClosed(view)
                //toast("Drawer closed")
            }

            override fun onDrawerOpened(drawerView: View) {
                super.onDrawerOpened(drawerView)
                //toast("Drawer opened")
            }
        }


        drawer_layout!!.addDrawerListener(mDrawerToggle)
        mDrawerToggle.setDrawerIndicatorEnabled(true)

        mDrawerToggle.syncState()

        navigation.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.mProfile -> {
                    val intent = Intent(this, Profile::class.java)
                    startActivity(intent)

                }


                R.id.mFavorite -> {
                    val intent = Intent(this, Favorite::class.java)
                    startActivity(intent)

                }

                R.id.mLogout -> {
                    toast("New clicked")
                }

            }
            // Close the drawer
            drawer_layout.closeDrawer(GravityCompat.START)
            true
        }

        mFilterIcon.setOnClickListener {
            val intent = Intent(this, Filter::class.java)
            startActivity(intent)
        }


    }

    private fun setCategoryFilter() {

        mFilterRecycler.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        val mFilterList = ArrayList<String>()
        mFilterList.add("تبادل ثقافي")
        mFilterList.add("فرص عمل")
        mFilterList.add("فرص تعليم")
        mFilterList.add("منحة مالية")
        mFilterList.add("منحة دراسية")
        mFilterList.add("جوائز ومسابقات")
        mFilterList.add("فرص إقامة")
        mFilterList.add(" دورات عبر الإنترنت")
        mFilterRecycler.adapter = CategoryFilterAdapter(mFilterList)
    }


    private fun setViewPagerAdapter() {

        val mSectionsPagerAdapter = TabPagerAdapter(supportFragmentManager)
        val mViewPager = findViewById<ViewPager>(R.id.viewpager)
        mViewPager.adapter = mSectionsPagerAdapter
        mViewPager.offscreenPageLimit = 2
        tabs.setupWithViewPager(mViewPager)


    }




    private fun Context.toast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }


    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }

    override fun ListIcon(recycler : RecyclerView){
        return mListIcon.setOnClickListener {
            recycler.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        }
    }
    override fun GridIcon(recycler: RecyclerView) {
        return mGridIcon.setOnClickListener {
            recycler.layoutManager =  GridLayoutManager(this, 2, GridLayout.VERTICAL, false)

        }
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        if (dialogFrag!!.isAdded()) {
            dialogFrag!!.dismiss()
            dialogFrag!!.show(supportFragmentManager, dialogFrag!!.getTag())
        }
        if (dialogFrag1!!.isAdded()) {
            dialogFrag1!!.dismiss()
            dialogFrag1!!.show(supportFragmentManager, dialogFrag1!!.getTag())
        }

    }

    override fun onOpenAnimationStart() {
        Log.d("aah_animation", "onOpenAnimationStart: ")
    }

    override fun onOpenAnimationEnd() {
        Log.d("aah_animation", "onOpenAnimationEnd: ")

    }

    override fun onCloseAnimationStart() {
        Log.d("aah_animation", "onCloseAnimationStart: ")

    }

    override fun onCloseAnimationEnd() {
        Log.d("aah_animation", "onCloseAnimationEnd: ")

    }


}
