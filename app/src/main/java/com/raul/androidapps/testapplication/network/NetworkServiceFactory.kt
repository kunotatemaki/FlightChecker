package com.raul.androidapps.testapplication.network

interface NetworkServiceFactory {

    companion object {
        const val BASE_URL = "https://s3-eu-west-1.amazonaws.com/"

    }

    fun getServiceInstance(): AppApi
}

