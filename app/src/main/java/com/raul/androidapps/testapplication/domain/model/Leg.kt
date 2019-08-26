package com.raul.androidapps.testapplication.domain.model


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
    val departure_airport: String,
    val arrival_airport: String,
    val departure_time: String,
    val arrival_time: String,
    val stops: Int,
    val airline_id: String,
    val duration_mins: Int
)