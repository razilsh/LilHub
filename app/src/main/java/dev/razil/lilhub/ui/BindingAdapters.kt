package dev.razil.lilhub.ui

import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import dev.razil.lilhub.GlideApp
import dev.razil.lilhub.R
import dev.razil.lilhub.api.NetworkState

@BindingAdapter("showWhen")
fun showWhen(progressBar: ProgressBar, networkState: NetworkState?) {
    if (networkState == null) return
    progressBar.visibility = when (networkState) {
        NetworkState.LOADING -> View.VISIBLE
        NetworkState.LOADED -> View.GONE
        is NetworkState.ERROR -> View.GONE
    }
}

@BindingAdapter("imageUrl")
fun ImageView.imageUrl(url: String) {
    if (!url.isBlank()) {
        val width = resources.getDimension(R.dimen.avatar_height)
        val radius: Int = (width / 2).toInt()
        GlideApp
            .with(this)
            .load(url)
            .transform(RoundedCorners(radius))
            .into(this)
    }
}
