package com.raul.androidapps.testapplication.network

sealed class ServerResult<out T> {

    data class Success<out T>(val data: T) : ServerResult<T>()

    data class Failure<out T>(val message: String?) : ServerResult<T>()

}
