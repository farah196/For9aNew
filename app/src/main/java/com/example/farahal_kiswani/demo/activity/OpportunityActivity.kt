package com.example.farahal_kiswani.demo.activity

import android.annotation.SuppressLint
import android.content.res.Configuration
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.Window
import com.allattentionhere.fabulousfilter.AAH_FabulousFragment
import com.example.farahal_kiswani.demo.R
import com.example.farahal_kiswani.demo.controller.ActivityCallBack
import com.example.farahal_kiswani.demo.fragment.InfoFragment
import com.example.farahal_kiswani.demo.fragment.MyFabFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_opportunity.*

class OpportunityActivity :  AppCompatActivity(),AAH_FabulousFragment.Callbacks, AAH_FabulousFragment.AnimationListener
{

    var dialogFrag: InfoFragment? = null
    var dialogFrag1: InfoFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_opportunity)
        dialogFrag1 = InfoFragment.newInstanceInfo()
        dialogFrag1!!.setParentFab(mFabButton1)
        mFabButtonInfo.setOnClickListener(
                object : View.OnClickListener {
                    override fun onClick(v: View) {
                        dialogFrag1!!.show(getSupportFragmentManager(), dialogFrag1!!.getTag())
                    }
                })

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

    override fun onResult(result: Any?) {
        return
    }

}