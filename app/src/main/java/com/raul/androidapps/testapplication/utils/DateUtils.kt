package com.raul.androidapps.testapplication.utils

import java.text.SimpleDateFormat
import java.util.*


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

object DateUtils {


    fun getHHmm(startTime: String?): String {
        return try {
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm", Locale.getDefault())
            val date = sdf.parse(startTime)
            SimpleDateFormat("HH:mm", Locale.getDefault()).format(date)
        } catch (e: Exception) {
            ""
        }
    }
}
