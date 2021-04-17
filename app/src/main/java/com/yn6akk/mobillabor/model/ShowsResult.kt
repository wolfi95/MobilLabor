package com.yn6akk.mobillabor.model

import com.google.gson.annotations.SerializedName

data class ShowsResult(
    @SerializedName("request_hash")
    var requestHash: String? = null,
    @SerializedName("days")
    var days: List<DaySchedule>? = null
)