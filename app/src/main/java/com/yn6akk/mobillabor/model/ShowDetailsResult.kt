package com.yn6akk.mobillabor.model

import com.google.gson.annotations.SerializedName

data class ShowDetailsResult (
    @SerializedName("details")
    var showDetails: ShowDetail? = null
)