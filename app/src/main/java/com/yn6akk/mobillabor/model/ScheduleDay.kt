package com.yn6akk.mobillabor.model

import io.swagger.client.models.Anime

data class ScheduleDay(
        val name: String? = null,
        val shows: Array<Anime>? = null
)