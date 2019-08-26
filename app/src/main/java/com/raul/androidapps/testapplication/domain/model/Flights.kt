package com.raul.androidapps.testapplication.domain.model

import com.google.gson.annotations.JsonAdapter
import com.raul.androidapps.testapplication.domain.deserializer.FlightsDeserializer


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


@JsonAdapter(FlightsDeserializer::class)
data class Flights constructor(
    val itineraries: List<Itinerary>
)