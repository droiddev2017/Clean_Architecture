package com.example.assignmentproject.framework.util

import android.content.Context
import android.view.View


/**
 * Created by Vinit Saxena on 31/07/21.
 */

fun Context.readFromAsset(file: String): String {
    return assets.open(file).bufferedReader().use {
        it.readText()
    }
}


fun Context.writeNetworkToInternalStorage(data: String) {
    try {
        val fOut = openFileOutput("names_network.json", Context.MODE_PRIVATE)
        fOut.write(data.toByteArray())
        fOut.close()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Context.readNetworkFromInternalStorage(): String? {
    try {
        val fin = openFileInput("names_network.json")
        var c: Int
        var temp = ""
        while (fin.read().also { c = it } != -1) {
            temp += Character.toString(c.toChar())
        }
        return temp
    } catch (ex: Exception) {
        return null
    }
}

fun Context.writeCacheToInternalStorage(data: String) {
    try {
        val fOut = openFileOutput("names_cache.json", Context.MODE_PRIVATE)
        fOut.write(data.toByteArray())
        fOut.close()
    } catch (ex: Exception) {
        ex.printStackTrace()
    }
}

fun Context.readCacheFromInternalStorage(): String? {
    try {
        val fin = openFileInput("names_cache.json")
        var c: Int
        var temp = ""
        while (fin.read().also { c = it } != -1) {
            temp = temp + Character.toString(c.toChar())
        }
        return temp
    } catch (ex: Exception) {
        return null
    }
}

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.hide() {
    visibility = View.GONE
}
