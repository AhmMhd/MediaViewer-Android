package com.aik.tor.util

import android.annotation.TargetApi
import android.content.ContentUris
import android.content.Context
import android.content.res.Resources
import android.database.Cursor
import android.media.MediaMetadataRetriever
import android.net.Uri
import android.os.Build
import android.os.Environment
import android.provider.DocumentsContract
import android.provider.MediaStore

import java.io.File


object FileUtils {

    fun getExtension(path: String): String {
        var extension = ""
        val token = path.split("\\.".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        extension = token[token.size - 1]


        return extension
    }


}
