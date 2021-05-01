package com.yn6akk.mobillabor.interactor.shows.events

import com.yn6akk.mobillabor.model.ShowDetail
import io.swagger.client.models.AnimeDetails

data class GetShowDetailsEvent (
    var code: Int = 0,
    var showDetails: AnimeDetails? = null,
    var throwable: Throwable? = null
)