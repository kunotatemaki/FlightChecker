package com.raul.androidapps.testapplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.whenever
import com.raul.androidapps.testapplication.domain.model.Flight
import com.raul.androidapps.testapplication.domain.model.Itinerary
import com.raul.androidapps.testapplication.domain.model.Leg
import com.raul.androidapps.testapplication.network.AppApi
import com.raul.androidapps.testapplication.network.NetworkServiceFactory
import com.raul.androidapps.testapplication.network.ServerResult
import com.raul.androidapps.testapplication.repository.RepositoryImpl
import kotlinx.coroutines.runBlocking
import okhttp3.ResponseBody.Companion.toResponseBody
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import retrofit2.Response


class RepositoryTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var networkServiceFactory: NetworkServiceFactory

    @Mock
    lateinit var api: AppApi

    @InjectMocks
    private lateinit var repository: RepositoryImpl
    private lateinit var flights: Flight

    @Before
    fun setUp() {
        val leg1 = Leg(
            "id1", "DEP1", "ARR1", "dtime", "arrTime", 0, "name1", "ariid", 300
        )
        val leg2 = Leg(
            "id2", "DEP2", "ARR1", "dtime", "arrTime", 0, "name1", "ariid", 300
        )
        val list: List<Itinerary> = mutableListOf(
            Itinerary("id1", listOf(leg1, leg2), "£32", "agent", 9f),
            Itinerary("id2", listOf(leg1, leg2), "£33", "agent", 9f)
        )
        flights = Flight(list)
        MockitoAnnotations.initMocks(this)
//        repository = RepositoryImpl(networkServiceFactory)

        whenever(networkServiceFactory.getServiceInstance())
            .thenReturn(
                api
            )
    }


    @Test
    fun testResponseSuccess() {
        runBlocking {
            whenever(api.getFlights())
                .thenReturn(
                    Response.success(flights)
                )
            val response: ServerResult<Flight> = repository.getFlights()
            assertEquals((response as ServerResult.Success<Flight>).data, flights)
        }
    }

    @Test
    fun testResponseError() {
        runBlocking {
            whenever(api.getFlights())
                .thenReturn(
                    Response.error(404, "".toResponseBody(null))
                )
            val response: ServerResult<Flight> = repository.getFlights()
            assertEquals(
                (response as ServerResult.Failure<Flight>).message.toString(),
                "Response.error()"
            )
        }
    }

}
