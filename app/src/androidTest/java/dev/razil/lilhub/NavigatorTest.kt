package dev.razil.lilhub

import androidx.navigation.findNavController
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

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
    fun repoList_isDisplayed() {
        onView(withId(R.id.repoList)).check(matches(isDisplayed()))
    }
}