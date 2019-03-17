package dev.razil.lilhub.ui.extensions

import android.util.DisplayMetrics
import android.view.View

fun View.toDp(dp: Float): Float {
    return dp * (context.resources.displayMetrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT)
}
