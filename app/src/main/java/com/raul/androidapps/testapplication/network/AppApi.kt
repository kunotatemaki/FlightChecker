package com.raul.androidapps.testapplication.network

import com.raul.androidapps.testapplication.domain.model.Flight
import retrofit2.Response
import retrofit2.http.GET

interface AppApi {

    @GET("skyscanner-prod-takehome-test/flights.json")
    suspend fun getFlights(): Response<Flight>


}
