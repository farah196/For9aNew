package com.example.farahal_kiswani.demo.activity

import android.animation.Animator
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.example.farahal_kiswani.demo.R
import android.content.Intent
import android.support.v4.app.ActivityCompat
import android.util.Log
import kotlinx.android.synthetic.main.splash_activity.*
import android.support.v4.app.ActivityOptionsCompat
import android.view.View


class Splash : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
       setupAnimation()


    }

    fun navigateToMainScreen() {

        val mainIntent = Intent(this@Splash, MainActivity::class.java)
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(this@Splash, mLogoTransition as View,
                "splash_transition")
        ActivityCompat.startActivity(this,mainIntent,options.toBundle())


    }


    private fun setupAnimation() {
        mLogoSplash.repeatCount = 0
        mLogoSplash.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
                Log.e("Animation:", "start")
            }

            override fun onAnimationEnd(animation: Animator) {
                Log.e("Animation:", "end")
//                mLogoTransition.visibility = View.VISIBLE
//                mLogoSplash.visibility = View.GONE

                navigateToMainScreen()

            }

            override fun onAnimationCancel(animation: Animator) {
                Log.e("Animation:", "cancel")
            }

            override fun onAnimationRepeat(animation: Animator) {
                Log.e("Animation:", "repeat")
            }
        })

        mLogoSplash.playAnimation()

    }
}