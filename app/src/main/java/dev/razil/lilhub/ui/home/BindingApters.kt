package dev.razil.lilhub.ui.home

import android.graphics.Color
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import dev.razil.lilhub.R

@BindingAdapter("languageColor")
fun setLanguageColor(view: TextView, languageColor: String?) {
    if (languageColor == null) return

    val color: Int = try {
        Color.parseColor(languageColor)
    } catch (e: IllegalArgumentException) {
        ContextCompat.getColor(view.context, R.color.colorTextSecondary)
    }
    view.setTextColor(color)
}
