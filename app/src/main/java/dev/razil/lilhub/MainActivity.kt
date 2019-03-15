package dev.razil.lilhub

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil.setContentView
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.google.android.material.bottomappbar.BottomAppBar
import dev.razil.lilhub.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBar: BottomAppBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = setContentView<MainActivityBinding>(this, R.layout.main_activity)
        appBar = binding.appBar
        setSupportActionBar(appBar)

        navController = findNavController(R.id.navHost)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        android.R.id.home -> {
            // TODO show drawer
            false
        }
        R.id.search -> {
            // TODO Implement search
            false
        }
        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp() = navController.navigateUp()
}
