package com.raul.androidapps.testapplication.repository

import com.raul.androidapps.testapplication.domain.model.Flight
import com.raul.androidapps.testapplication.network.ServerResult


interface Repository {

    suspend fun getFlights(): ServerResult<Flight>


}