package com.yn6akk.mobillabor.ui.details

import com.yn6akk.mobillabor.model.Show
import com.yn6akk.mobillabor.model.ShowDetail

interface DetailsScreen {
    fun showDetails(shows: ShowDetail)
    fun showNetworkError(errorMsg: String)
}