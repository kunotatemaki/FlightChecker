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


data class Flights constructor(
    val itineraries: List<Itinerary>,
    val legs: List<Leg>
)