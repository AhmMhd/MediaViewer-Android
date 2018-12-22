package com.abdulhakeem.mediaviewer

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_media_viewer.*

class MediaViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_viewer)

        val mediaList = ArrayList<String>()
        mediaList.addAll(intent.extras.getStringArrayList(Constant.MEDIA_LIST_EXTRA))

        val adapter = MediaViewAdapter(this,mediaList)
        viewpager.adapter = adapter
        dots_indicator.setViewPager(viewpager)

        back.setOnClickListener { finish() }
    }
}