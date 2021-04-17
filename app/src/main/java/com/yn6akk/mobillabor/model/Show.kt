package com.yn6akk.mobillabor.model

import com.google.gson.annotations.SerializedName

data class Show (
    @SerializedName("mal_id")
    var Id: Int? = null,
    @SerializedName("url")
    var Url: String? = null,
    @SerializedName("title")
    var Title: String? = null,
)