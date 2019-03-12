package dev.razil.lilhub

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.razil.lilhub.ui.home.HomeFragment
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class HomeFragmentTest {
    private lateinit var fragmentScenario: FragmentScenario<HomeFragment>

    @Before
    fun setUp() {
        fragmentScenario = FragmentScenario.launchInContainer(HomeFragment::class.java)
    }

    @Test
    fun test() {
        onView(withId(R.id.repoList)).check(matches(isDisplayed()))
    }
}
