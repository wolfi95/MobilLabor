package com.yn6akk.mobillabor.ui.main

import com.yn6akk.mobillabor.model.Show

interface MainScreen {
    fun showShows(shows: List<Show>?)
    fun showNetworkError(errorMsg: String)
}