package com.test.rocketlaunches.home.ui

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
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