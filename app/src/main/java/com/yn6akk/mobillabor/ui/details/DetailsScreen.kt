package com.yn6akk.mobillabor.ui.details

import io.swagger.client.models.AnimeDetails

interface DetailsScreen {
    fun showDetails(show: AnimeDetails)
    fun showNetworkError(errorMsg: String)
}