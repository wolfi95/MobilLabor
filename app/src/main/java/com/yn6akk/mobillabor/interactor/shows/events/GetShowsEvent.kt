package com.yn6akk.mobillabor.interactor.shows.events

import io.swagger.client.models.AnimeList

data class GetShowsEvent(
    var code: Int = 0,
    var data: AnimeList? = null,
    var throwable: Throwable? = null
)