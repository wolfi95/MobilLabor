package com.yn6akk.mobillabor.ui.main

import io.swagger.client.models.AnimeList

interface MainScreen {
    fun showShows(shows: AnimeList?)
    fun showNetworkError(errorMsg: String)
}