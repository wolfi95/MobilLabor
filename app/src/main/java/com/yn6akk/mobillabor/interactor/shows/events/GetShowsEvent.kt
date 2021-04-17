package com.yn6akk.mobillabor.interactor.shows.events

import com.yn6akk.mobillabor.model.Show

data class GetShowsEvent(
    var code: Int = 0,
    var shows: List<Show>? = null,
    var throwable: Throwable? = null
)