package dev.razil.lilhub.ui

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

/**
 * Adds spaces between the items in a [RecyclerView].
 */
class SpacesItemDecoration(
    private val space: Int = 40,
    context: Context,
    orientation: Int
) :
    DividerItemDecoration(context, orientation) {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        outRect.top = space
        outRect.bottom = space
    }
}
