package com.test.spacelens.utils

import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment

/**
 * Context Extensions
 */
fun Context.toastLong(text: CharSequence) = Toast.makeText(this, text, Toast.LENGTH_LONG).show()

fun Context.toastShort(text: CharSequence) = Toast.makeText(this, text, Toast.LENGTH_SHORT).show()


inline fun <T> justTry(block: () -> T) = try {
    block()
} catch (e: Throwable) {
}

fun Fragment.setLightStatusBar() {
    val window = activity?.window
    window?.apply {
        statusBarColor = ContextCompat.getColor(requireContext(), android.R.color.transparent)
        decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR or View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LAYOUT_STABLE
    }
}

/**
 * Logger extension
 */
fun logger(mode: Int, tag: String, message: String, t: Throwable? = null) {

    if (t == null) {
        when (mode) {
            Log.DEBUG -> Log.d(tag, message)
            Log.ERROR -> Log.e(tag, message)
            Log.INFO -> Log.i(tag, message)
            Log.VERBOSE -> Log.v(tag, message)
            Log.WARN -> Log.w(tag, message)
            else -> Log.wtf(tag, message)
        }
    } else {
        when (mode) {
            Log.DEBUG -> Log.d(tag, message, t)
            Log.ERROR -> Log.e(tag, message, t)
            Log.INFO -> Log.i(tag, message, t)
            Log.VERBOSE -> Log.v(tag, message, t)
            Log.WARN -> Log.w(tag, message, t)
            else -> Log.wtf(tag, message, t)
        }
    }
}


fun View.makeInvisible() {
    this.visibility = View.INVISIBLE
}

fun View.setOpacity(percent: Int) {
    this.background.alpha = percent
}
