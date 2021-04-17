package com.yn6akk.mobillabor.model

import com.google.gson.annotations.SerializedName

data class DaySchedule (
    @SerializedName("shows")
    var shows: List<Show>? = null
)