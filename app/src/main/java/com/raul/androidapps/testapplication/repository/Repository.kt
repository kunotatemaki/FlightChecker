package com.raul.androidapps.testapplication.repository

import com.raul.androidapps.testapplication.domain.model.Flights
import com.raul.androidapps.testapplication.network.ServerResult


interface Repository {

    suspend fun getFlights(): ServerResult<Flights>


}