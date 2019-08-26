package com.raul.androidapps.testapplication.domain.model

import com.google.gson.annotations.SerializedName
import com.raul.androidapps.testapplication.utils.AppConstants
import com.raul.androidapps.testapplication.utils.DateUtils


/**
 * Copyright (C) Rookia - All Rights Reserved
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 *
 * Written by Roll <raulfeliz@gmail.com>, August 2019
 *
 *
 */

data class Leg constructor(
    val id: String,
    @SerializedName("departure_airport")
    val departureAirport: String,
    @SerializedName("arrival_airport")
    val arrivalAirport: String,
    @SerializedName("departure_time")
    val departureTime: String,
    @SerializedName("arrival_time")
    val arrivalTime: String,
    val stops: Int,
    @SerializedName("airline_name")
    val airlineName: String,
    @SerializedName("airline_id")
    val airlineId: String,
    @SerializedName("duration_mins")
    val durationMins: Int
){

    fun getLogoUrl(): String = AppConstants.BASE_LOGO_URL.replace("{id}", airlineId)

    fun getAirports(): String = "$departureAirport-$arrivalAirport, $airlineName"

    fun getFlightTime(): String = "${DateUtils.getHHmm(departureTime)} - ${DateUtils.getHHmm(arrivalTime)}"

    fun getFlightDuration(): String {
        val hours = durationMins / 60
        val min = durationMins%60
        return "${hours}h ${min}m"
    }

}