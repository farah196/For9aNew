package com.example.farahal_kiswani.demo.activity
import android.os.Bundle
import android.support.design.widget.AppBarLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.animation.AlphaAnimation
import android.widget.Toast
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.fragment.Null
import com.example.farahal_kiswani.demo.fragment.Null1
import com.example.farahal_kiswani.demo.fragment.Null2
import com.example.farahal_kiswani.demo.fragment.Pinned
import com.flyco.tablayout.listener.OnTabSelectListener
import kotlinx.android.synthetic.main.profile_activity.*


class Profile : AppCompatActivity(), OnTabSelectListener , AppBarLayout.OnOffsetChangedListener{
    private val mContext = this

    private val PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR = 0.6f
    private val PERCENTAGE_TO_HIDE_TITLE_DETAILS = 0.3f
    private val ALPHA_ANIMATIONS_DURATION = 200

    private var mIsTheTitleVisible = false
    private var mIsTheTitleContainerVisible = true
    private val mPinned = ArrayList<Fragment>()
    private val mNull1 = ArrayList<Fragment>()
    private val mNull2 = ArrayList<Fragment>()
    private val mNull3 = ArrayList<Fragment>()
    private val mTitles = arrayOf(

            "Pinned","Null","Null","Null")

    private var mAdapter: MyPagerAdapter? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profile_activity)

        setSupportActionBar(findViewById<View>(R.id.main_toolbar) as Toolbar)

        main_appbar!!.addOnOffsetChangedListener(this)
        main_toolbar.inflateMenu(R.menu.menu_user_profile)
        startAlphaAnimation(main_textview_title, 0, View.INVISIBLE)
       initActionBar()
        mNestedLayout.isFillViewport=true

        for (title in mTitles) {

            mPinned.add(Pinned.getInstance())

            mNull1.add(Null.getInstance())
            mNull2.add(Null1.getInstance())
            mNull3.add(Null2.getInstance())

        }

        mAdapter = MyPagerAdapter(supportFragmentManager)

        viewpager_profile!!.setAdapter(mAdapter)
        tabs_profile.setViewPager(viewpager_profile)
        tabs_profile.setOnTabSelectListener(this)
        tabs_profile.showDot(4)
        tabs_profile.showMsg(3,5)
        tabs_profile.setMsgMargin(3, 0.0F, 10F)
        viewpager_profile.setCurrentItem(1)
    }


    override fun onTabSelect(position: Int) {

        Toast.makeText(mContext, "onTabSelect&position--->$position", Toast.LENGTH_SHORT).show()

    }


    override fun onTabReselect(position: Int) {

        Toast.makeText(mContext, "onTabReselect&position--->$position", Toast.LENGTH_SHORT).show()

    }


    private inner class MyPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {


        override fun getCount(): Int {

            return mPinned.size

        }


        override fun getPageTitle(position: Int): CharSequence? {

            return mTitles[position]

        }


        override fun getItem(position: Int): Fragment {

            return when (position) {
                0 -> {
                  mPinned[position]
                }
                1 -> {
                    mNull1[position]


                }
                2->
                {
                    mNull2[position]
                }
                3->
                {
                    mNull3[position]
                }
                else -> mPinned[position]
            }

        }

    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                super.onBackPressed()
                return true
            }

            R.id.action_edit -> {
                Toast.makeText(this, "edit", Toast.LENGTH_LONG).show()
                return true

            }


        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val menuInflater = menuInflater
        menuInflater.inflate(R.menu.menu_user_profile, menu)
        return true
    }

    private fun initActionBar() {
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        supportActionBar!!.setDisplayShowHomeEnabled(true)
        supportActionBar!!.setDisplayShowTitleEnabled(false)
    }

    override fun onOffsetChanged(appBarLayout: AppBarLayout, offset: Int) {
        val maxScroll = appBarLayout.totalScrollRange
        val percentage = Math.abs(offset).toFloat() / maxScroll.toFloat()

        handleAlphaOnTitle(percentage)
        handleToolbarTitleVisibility(percentage)
    }

    private fun handleToolbarTitleVisibility(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_SHOW_TITLE_AT_TOOLBAR) {

            if (!mIsTheTitleVisible) {
                startAlphaAnimation(main_textview_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.VISIBLE)
                mIsTheTitleVisible = true
            }

        } else {

            if (mIsTheTitleVisible) {
                startAlphaAnimation(main_textview_title, ALPHA_ANIMATIONS_DURATION.toLong(), View.INVISIBLE)
                mIsTheTitleVisible = false
            }
        }
    }

    private fun handleAlphaOnTitle(percentage: Float) {
        if (percentage >= PERCENTAGE_TO_HIDE_TITLE_DETAILS) {
            if (mIsTheTitleContainerVisible) {
                startAlphaAnimation(mLayout, ALPHA_ANIMATIONS_DURATION.toLong(), View.INVISIBLE)
                mIsTheTitleContainerVisible = false
            }

        } else {

            if (!mIsTheTitleContainerVisible) {
                startAlphaAnimation(mLayout, ALPHA_ANIMATIONS_DURATION.toLong(), View.VISIBLE)
                mIsTheTitleContainerVisible = true
            }
        }
    }

    fun startAlphaAnimation(v: View, duration: Long, visibility: Int) {
        val alphaAnimation = if (visibility == View.VISIBLE)
            AlphaAnimation(0f, 1f)
        else
            AlphaAnimation(1f, 0f)

        alphaAnimation.duration = duration
        alphaAnimation.fillAfter = true
        v.startAnimation(alphaAnimation)
    }

}