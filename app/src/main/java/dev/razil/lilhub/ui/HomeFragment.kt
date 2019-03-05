package dev.razil.lilhub.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import dev.razil.lilhub.R
import dev.razil.lilhub.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return DataBindingUtil.inflate<HomeFragmentBinding>(
            inflater,
            R.layout.home_fragment,
            container,
            false
        ).root
    }
}
