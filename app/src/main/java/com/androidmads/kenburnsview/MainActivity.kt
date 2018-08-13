package com.androidmads.kenburnsview

import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.flaviofaria.kenburnsview.KenBurnsView
import com.flaviofaria.kenburnsview.Transition

class MainActivity : AppCompatActivity() {

    private var mImg: KenBurnsView? = null
    private var fab: FloatingActionButton? = null
    private var isPlaying = true
    private var imageId: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageId = R.drawable.img1

        fab = findViewById(R.id.fab)
        mImg = findViewById(R.id.img)

        fab!!.setOnClickListener {
            if (isPlaying) {
                mImg!!.pause()
                fab!!.setImageResource(R.drawable.ic_play)
            } else {
                mImg!!.resume()
                fab!!.setImageResource(R.drawable.ic_pause)
            }
            isPlaying = !isPlaying
        }

        mImg!!.setTransitionListener(object : KenBurnsView.TransitionListener {
            override fun onTransitionStart(transition: Transition) {

            }

            override fun onTransitionEnd(transition: Transition) {
                if (imageId == R.drawable.img1) {
                    imageId = R.drawable.img2
                    mImg!!.setImageResource(R.drawable.img2)
                } else {
                    imageId = R.drawable.img1
                    mImg!!.setImageResource(R.drawable.img1)
                }
            }
        })
    }
}
