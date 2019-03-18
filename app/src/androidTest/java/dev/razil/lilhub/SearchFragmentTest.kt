package dev.razil.lilhub

import androidx.fragment.app.testing.FragmentScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.UiDevice
import com.schibsted.spain.barista.assertion.BaristaFocusedAssertions
import com.schibsted.spain.barista.interaction.BaristaEditTextInteractions.writeTo
import com.schibsted.spain.barista.interaction.BaristaKeyboardInteractions
import dev.razil.lilhub.ui.search.SearchFragment
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class SearchFragmentTest {
    private lateinit var fragmentScenario: FragmentScenario<SearchFragment>

    @Before
    fun setUp() {
        fragmentScenario = FragmentScenario.launchInContainer(SearchFragment::class.java, null, R.style.AppTheme, null)
    }

    @Test
    fun onLaunchCheckKeyboardIsOpen() {
        BaristaFocusedAssertions.assertFocused(R.id.editText)
        assertTrue(isKeyboardOpenedShellCheck())
        writeTo(R.id.editText, "hello world")
        BaristaKeyboardInteractions.pressImeActionButton(R.id.editText)
        assertFalse(isKeyboardOpenedShellCheck())
    }

    /**
     * https://stackoverflow.com/a/53118977
     *
     * This method works like a charm
     *
     * SAMPLE CMD OUTPUT:
     * mShowRequested=true mShowExplicitlyRequested=true mShowForced=false mInputShown=true
     */
    private fun isKeyboardOpenedShellCheck(): Boolean {
        val checkKeyboardCmd = "dumpsys input_method | grep mInputShown"

        try {
            return UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
                .executeShellCommand(checkKeyboardCmd).contains("mInputShown=true")
        } catch (e: IOException) {
            throw RuntimeException("Keyboard check failed", e)
        }
    }
}
