package com.abdulhakeem.mediaviewer

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.DownloadListener
import kotlinx.android.synthetic.main.activity_media_viewer.*

class MediaViewer : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_media_viewer)

        AndroidNetworking.initialize(applicationContext)
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

        val adapter = MediaViewAdapter(this, mediaList) { link: String ->
            if (hasPermissions(applicationContext, *permissions())) {
                startdownload(link)
            } else {
                askForPermission(permissions())
            }
        }
        viewpager.adapter = adapter
        dots_indicator.setViewPager(viewpager)

        back.setOnClickListener { finish() }
    }

    private fun startdownload(link: String) {

        try {
            val fileName = "${System.currentTimeMillis()}.png"

            AndroidNetworking.download(link, Constant.PICTURE_PATH, fileName)
                .build()
                .startDownload(object : DownloadListener {
                    override fun onDownloadComplete() {
                        Toast.makeText(applicationContext, "DownLoad Complete", Toast.LENGTH_SHORT)
                            .show();
                    }

                    override fun onError(anError: ANError?) {

                    }
                })
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    /*asking for user permission to write*/
    private fun askForPermission(permissions: Array<String>) {
        ActivityCompat.requestPermissions(
            this,
            permissions,
            101
        )
    }

    /*setting permisions to ask*/
    private fun permissions() = arrayOf(
        Manifest.permission.READ_EXTERNAL_STORAGE,
        Manifest.permission.WRITE_EXTERNAL_STORAGE
    )

    /*checking if permission are allowed*/
    fun hasPermissions(context: Context?, vararg permissions: String?): Boolean {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && context != null &&
            permissions != null
        ) {
            for (permission in permissions) {
                if (ActivityCompat.checkSelfPermission(
                        context,
                        permission!!
                    ) != PackageManager.PERMISSION_GRANTED
                ) {
                    return false
                }
            }
        }
        return true
    }
}
