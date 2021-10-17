package com.lush.rocketlaunches.home.ui

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.lush.rocketlaunches.home.R
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeFragmentTest {

    private val fragment =
        HomeFragment()

    @get:Rule
    val fragmentRule = createRule(fragment)

    @Before
    fun setUp() {
        startKoin {
            modules(testModules)
        }
    }

    @Test
    fun getRocketLaunches() {
        /*onView(withId(R.id.launch_list_recycler))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<MyAdapter.ViewHolder>(1,clickItemWithId(R.id.button)))*/
    }
}