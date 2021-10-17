package com.test.rocketlaunches.data

import com.test.rocketlaunches.data.remote.api.SpaceService
import com.test.rocketlaunches.data.remote.dto.LaunchDto
import com.test.rocketlaunches.data.repository.implementation.LaunchesRepositoryImplementation
import com.test.rocketlaunches.domain.model.Launch
import com.test.rocketlaunches.domain.model.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner
import retrofit2.Response
import retrofit2.Retrofit

@RunWith(MockitoJUnitRunner::class)
class LaunchesRepositoryTest : KoinTest {

    private val retrofit by inject<Retrofit>()
    private lateinit var service: SpaceService
    private val mainThreadSurrogate = newSingleThreadContext("UI Thread")

    @Before
    fun setUp() {
        startKoin {
            modules(networkModule)
        }

        service = retrofit.create(SpaceService::class.java)
        Dispatchers.setMain(mainThreadSurrogate)
    }

    @Test
    fun testLocal() {
        val res = runBlocking {
            val mockResponse = Response.success(mockLaunchDtoList)
            val mockService = Mockito.mock(SpaceService::class.java)

            `when`(mockService.getRocketLaunches("falcon9")).thenReturn(mockResponse)
            val repository = LaunchesRepositoryImplementation(mockService)
            repository.getRocketLaunches("falcon9")
        }

        assertEquals(Result.Status.SUCCESS, res.status)
        assertEquals(mockLaunchList, res.data)
    }

    @Test
    fun testRemote() {
        val repository = LaunchesRepositoryImplementation(service)

        val res = runBlocking {
            repository.getRocketLaunches("falcon9")
        }

        assertEquals(Result.Status.SUCCESS, res.status)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        mainThreadSurrogate.close()

        stopKoin()
    }

    private val mockLaunchDtoList = listOf(
        LaunchDto(0, "Falcon 9 Test Flight", 0L, true, null),
        LaunchDto(1, "COTS-1", 0L, true, null),
    )

    private val mockLaunchList = listOf(
        Launch(0, "Falcon 9 Test Flight", 0L, true, null),
        Launch(1, "COTS-1", 0L, true, null),
    )
}
