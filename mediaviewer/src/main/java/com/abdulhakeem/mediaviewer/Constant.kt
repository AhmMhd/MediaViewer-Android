package com.abdulhakeem.mediaviewer

import android.os.Environment

object Constant {

    private const val PROFILE_IMAGE = "/images"
    private val APP_DIR =
        Environment.getExternalStorageDirectory().toString() + "/MediaViewer"

    val MEDIA_LIST_EXTRA = "media_list_extra"
    val BACKGROUND_COLOR = "BACKGROUND_COLOR"
    val MEDIA_TITLE = "MEDIA_TITLE"
    val MEDIA_TITLE_COLOR = "MEDIA_TITLE_COLOR"
    val MEDIA_BACK_COLOR = "MEDIA_BACK_COLOR"
    val PICTURE_PATH = "$APP_DIR$PROFILE_IMAGE"

}