package dev.razil.lilhub.ui

import android.view.View
import android.widget.ProgressBar
import androidx.databinding.BindingAdapter
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
