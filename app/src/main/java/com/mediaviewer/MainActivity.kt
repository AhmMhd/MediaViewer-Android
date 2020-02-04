package com.mediaviewer

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.abdulhakeem.mediaviewer.Constant
import com.abdulhakeem.mediaviewer.MediaViewer

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mediaList = ArrayList<String>()
        mediaList.add("https://worldsportlogos.com/wp-content/uploads/2018/02/Arsenal-logo.png")
        mediaList.add("https://sample-videos.com/video123/mp4/240/big_buck_bunny_240p_1mb.mp4")
        mediaList.add("https://upload.wikimedia.org/wikipedia/commons/a/ae/Warrenvillegrove.jpg")
        mediaList.add("http://img.phone.baidu.com/public/uploads/store_2/2/8/6/286c53ae56fa24f37d08d013de10d61c.png")

        val intent = Intent(this, MediaViewer::class.java)
        intent.putExtra(Constant.MEDIA_LIST_EXTRA,mediaList)
        intent.putExtra(Constant.BACKGROUND_COLOR,"#ffffff")
        intent.putExtra(Constant.MEDIA_TITLE,"")
        intent.putExtra(Constant.MEDIA_TITLE_COLOR,"#000000")
        intent.putExtra(Constant.MEDIA_BACK_COLOR,"#000000")
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)

    }
}
