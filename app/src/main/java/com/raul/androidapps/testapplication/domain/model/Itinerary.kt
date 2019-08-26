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

data class Itinerary constructor(
    val id: String,
    val legs: List<Leg>,
    val price: String,
    val agent: String,
    val agent_rating: Float
)