package com.raul.androidapps.testapplication.domain.model

import com.google.gson.annotations.SerializedName
import com.raul.androidapps.testapplication.R
import com.raul.androidapps.testapplication.resources.ResourcesManager


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
    @SerializedName("agent_rating")
    val agentRating: Float
){

}