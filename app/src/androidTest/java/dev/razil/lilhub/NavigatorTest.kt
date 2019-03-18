package dev.razil.lilhub

import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import com.google.common.truth.Truth.assertThat
import com.schibsted.spain.barista.assertion.BaristaVisibilityAssertions.assertNotDisplayed
import com.schibsted.spain.barista.interaction.BaristaMenuClickInteractions.clickMenu
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigatorTest {
    private lateinit var activityScenario: ActivityScenario<MainActivity>

    @get:Rule
    var activityRule: ActivityTestRule<MainActivity> = ActivityTestRule(MainActivity::class.java)

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

    @Test
    fun onClickSearchIconNavigatesToSearchFragment() {
        clickMenu(R.id.search)
        val navController = activityRule.activity.findNavController(R.id.navHost)
        assertThat(navController.currentDestination?.id).isEqualTo(R.id.searchFragment)
        assertNotDisplayed(R.id.appBar)
    }
}
