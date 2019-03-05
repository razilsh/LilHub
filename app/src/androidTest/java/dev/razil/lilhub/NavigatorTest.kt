package dev.razil.lilhub

import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class NavigatorTest {
    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @Before
    fun setUp() {
        activityScenario = ActivityScenario.launch(MainActivity::class.java)

    }

    @Test
    fun navController_should_launch_HomeFragment() {
        activityScenario.onActivity { activity ->
            val navController = activity.findNavController(R.id.navHost)
            assertThat(navController.currentDestination?.id).isEqualTo(R.id.homeFragment)
            assertThat(navController.currentDestination?.id).isEqualTo(navController.graph.startDestination)
        }
    }
}