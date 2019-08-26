package com.raul.androidapps.testapplication.repository

import com.raul.androidapps.testapplication.domain.ServerResult
import com.raul.androidapps.testapplication.domain.model.Flights


interface Repository {

    suspend fun getFlights(): ServerResult<Flights>


}