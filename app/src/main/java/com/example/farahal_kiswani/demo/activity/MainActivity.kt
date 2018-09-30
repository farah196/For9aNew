package com.example.farahal_kiswani.demo.activity

import android.content.Context
import android.content.Intent
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
import com.example.farahal_kiswani.demo.ApiService
import com.example.farahal_kiswani.demo.adapter.OpportunityAdapter
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.adapter.CategoryFilterAdapter
import com.example.farahal_kiswani.demo.adapter.TabPagerAdapter
import com.example.farahal_kiswani.demo.controller.ActivityCallBack
import kotlinx.android.synthetic.main.activity_main.*
import com.example.farahal_kiswani.demo.models.Opportunity
import com.example.farahal_kiswani.demo.models.TimelineResponse2
import com.example.farahal_kiswani.demo.util.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity(), ActivityCallBack {



    val oppertinuitySearchList = ArrayList<Opportunity>()
    var sinceIdString = ""
    var opportunityAdapter: OpportunityAdapter = OpportunityAdapter(ArrayList())
    override fun onCreate(savedInstanceState: Bundle?) {
        window.requestFeature(Window.FEATURE_CONTENT_TRANSITIONS)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar: Toolbar = findViewById(R.id.toolbar_main)
        setSupportActionBar(toolbar)


        setViewPagerAdapter()
        setCategoryFilter()
        mSearchBar.setOnClickListener {
            Search()
        }
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

    private fun Search() {

        mSearchList.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

        opportunityAdapter = OpportunityAdapter(oppertinuitySearchList)
        mSearchList.adapter = opportunityAdapter
        mSearchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener, android.support.v7.widget.SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                sinceIdString = ""
                Request(query)
                //Task HERE
                return false
            }

        })
    }


    private fun Request(term: String) {
        val apiServices = ApiClient.client.create(ApiService::class.java)

        val call = apiServices.getSearch(10, sinceIdString, term);

        call.enqueue(object : Callback<TimelineResponse2> {
            override fun onResponse(call: Call<TimelineResponse2>, response: Response<TimelineResponse2>) {
                if (response.isSuccessful) {

                    if (!response.body()?.results!!.isEmpty()) {
                        opportunityAdapter.updateDataset(response.body()?.results!!)
                        sinceIdString = opportunityAdapter.infoList.get(opportunityAdapter.infoList.size - 1).id.toString()

                    } else {
                        //Hanndle empty dataaset
                        opportunityAdapter.updateDataset(ArrayList())


                    }

                }


            }

            override fun onFailure(call: Call<TimelineResponse2>?, t: Throwable?) {
                Log.i("search", "Response Error")
            }

        })


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

}
