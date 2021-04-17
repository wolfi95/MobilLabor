package com.yn6akk.mobillabor.model

import com.google.gson.annotations.SerializedName

data class Shows (
    @SerializedName("items")
    var items: List<Show>? = null
)