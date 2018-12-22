package com.abdulhakeem.mediaviewer

import android.content.Context
import android.content.Intent
import android.graphics.drawable.Drawable
import android.media.MediaPlayer
import android.net.Uri
import android.os.Parcelable
import android.support.v4.view.PagerAdapter
import android.text.Layout
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.aik.tor.util.FileUtils
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import java.io.File
import android.widget.LinearLayout
import android.widget.RelativeLayout
import com.bogdwellers.pinchtozoom.ImageMatrixTouchHandler
import kotlinx.android.synthetic.main.li_media_viewer.view.*


class MediaViewAdapter(var context: Context, var list : ArrayList<String>) : PagerAdapter()
{
    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        val view = LayoutInflater.from(context).inflate(R.layout.li_media_viewer,container,false)

        view.thumbnail.setOnTouchListener(ImageMatrixTouchHandler(context));

        Glide.with(context)
                .load(list.get(position))
                .thumbnail(0.1f)
                .listener(object : RequestListener<Drawable?>
                {
                    override fun onLoadFailed(e: GlideException?, model: Any?, target: Target<Drawable?>?, isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: Drawable?, model: Any?, target: Target<Drawable?>?, dataSource: DataSource?, isFirstResource: Boolean): Boolean {
                        view.progressbar.visibility = View.GONE
                        return false
                    }
                })
                .into(view.thumbnail)

        when(FileUtils.getExtension(list.get(position)))
        {
            "jpg","jpeg","png"->{view.video_overlay.visibility = View.GONE}
            else -> {view.video_overlay.visibility = View.VISIBLE}
        }

        view.video_overlay.setOnClickListener {
            val videoIntent = Intent(Intent.ACTION_VIEW)
            videoIntent.setDataAndType(Uri.parse(list.get(position)),"video/*")
            context.startActivity(videoIntent)
        }
        container.addView(view)
        return view
    }

    override fun isViewFromObject(p0: View, p1: Any): Boolean {
        return p0 == p1
    }

    override fun getCount()=list.size

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as RelativeLayout)
    }
}