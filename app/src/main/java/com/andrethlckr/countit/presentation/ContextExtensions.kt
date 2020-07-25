package com.andrethlckr.countit.presentation

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.Toast
import androidx.annotation.*
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.content.ContextCompat

fun Context.toast(@StringRes resource: Int, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, resource, duration).show()
}

@ColorInt fun Context.getColorCompat(@ColorRes colorRes: Int): Int {
    return ContextCompat.getColor(this, colorRes)
}

fun Context.getDrawableCompat(@DrawableRes drawableRes: Int): Drawable {
    return AppCompatResources.getDrawable(this, drawableRes)!!
}

fun View.gone() {
    if (visibility != View.GONE) {
        visibility = View.GONE
    }
}

fun View.visible() {
    if (visibility != View.VISIBLE) {
        visibility = View.VISIBLE
    }
}

fun View.isVisible(isVisible: Boolean) {
    if (isVisible) visible() else gone()
}

@Dimension(unit = Dimension.PX) fun Int.dpToPx() : Int =
    (this * Resources.getSystem().displayMetrics.density).toInt()


