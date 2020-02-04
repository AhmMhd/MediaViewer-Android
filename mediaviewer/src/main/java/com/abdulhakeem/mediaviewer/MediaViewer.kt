package com.abdulhakeem.mediaviewer

import android.graphics.Color
import android.graphics.ColorFilter
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_media_viewer.*

class MediaViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_viewer)

        val mediaList = ArrayList<String>()
        if (intent.hasExtra(Constant.MEDIA_LIST_EXTRA))
            mediaList.addAll(intent.extras.getStringArrayList(Constant.MEDIA_LIST_EXTRA))


        if (intent.hasExtra(Constant.BACKGROUND_COLOR))
            background.setBackgroundColor(Color.parseColor(intent.getStringExtra(Constant.BACKGROUND_COLOR)))

        if (intent.hasExtra(Constant.MEDIA_TITLE))
            toolbarTitle.text = intent.getStringExtra(Constant.MEDIA_TITLE)

        if (intent.hasExtra(Constant.MEDIA_TITLE_COLOR))
            toolbarTitle.setTextColor(Color.parseColor(intent.getStringExtra(Constant.MEDIA_TITLE_COLOR)))

        if (intent.hasExtra(Constant.MEDIA_BACK_COLOR))
            back.setColorFilter(Color.parseColor(intent.getStringExtra(Constant.MEDIA_BACK_COLOR)))

        val adapter = MediaViewAdapter(this, mediaList)
        viewpager.adapter = adapter
        dots_indicator.setViewPager(viewpager)

        back.setOnClickListener { finish() }
    }
}