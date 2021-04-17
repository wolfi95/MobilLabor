package com.yn6akk.mobillabor.interactor.shows.events

import com.yn6akk.mobillabor.model.Show
import com.yn6akk.mobillabor.model.ShowDetail

data class GetShowDetailsEvent (
    var code: Int = 0,
    var showDetails: ShowDetail? = null,
    var throwable: Throwable? = null
)