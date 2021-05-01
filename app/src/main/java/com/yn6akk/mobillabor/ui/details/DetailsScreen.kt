package com.yn6akk.mobillabor.ui.details

import com.yn6akk.mobillabor.model.ShowDetail
import io.swagger.client.models.AnimeDetails

interface DetailsScreen {
    fun showDetails(shows: AnimeDetails)
    fun showNetworkError(errorMsg: String)
}