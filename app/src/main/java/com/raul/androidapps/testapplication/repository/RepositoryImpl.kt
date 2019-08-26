package com.raul.androidapps.testapplication.repository


import com.raul.androidapps.testapplication.domain.ServerResult
import com.raul.androidapps.testapplication.domain.model.Flights
import com.raul.androidapps.testapplication.network.NetworkServiceFactory
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImpl @Inject constructor(private val networkServiceFactory: NetworkServiceFactory) :
    Repository {
    override suspend fun getFlights(): ServerResult<Flights> {
        return try {
            val resp = networkServiceFactory.getServiceInstance().getFlights(
            )
            resp.body()?.let {
                if (resp.isSuccessful) {
                    ServerResult.Success(it)
                } else {
                    ServerResult.Failure<Flights>(resp.message())
                }
            } ?: ServerResult.Failure(resp.message())
        } catch (e: Throwable) {
            Timber.e("Error fetching from network")
            ServerResult.Failure(e.message)
        }
    }


}