package com.lush.rocketlaunches.home.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lush.rocketlaunches.domain.model.Result
import com.lush.rocketlaunches.home.getOrAwaitValue
import com.lush.rocketlaunches.home.rule.CoroutinesTestRule
import com.lush.rocketlaunches.home.rule.runBlockingTest
import com.lush.rocketlaunches.home.testModules
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject

@RunWith(JUnit4::class)
class HomeViewModelTest : KoinTest {

    @get:Rule
    val executorRule = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesRule = CoroutinesTestRule()

    private val viewModel: HomeViewModel  by inject()

    @Before
    fun setUp() {
        startKoin {
            modules(testModules)
        }
    }

    @After
    fun after() {
        stopKoin()
    }

    @Test
    fun testGetRocketLaunches() {
        coroutinesRule.runBlockingTest {
            viewModel.getRocketLaunches()

            val launches = viewModel.launches.getOrAwaitValue()
            assertEquals(Result.Status.SUCCESS, launches.status)
        }
    }
}
