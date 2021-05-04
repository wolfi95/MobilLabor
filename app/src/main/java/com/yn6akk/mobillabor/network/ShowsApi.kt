package com.yn6akk.mobillabor.network

import io.swagger.client.models.AnimeDetails
import io.swagger.client.models.AnimeList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ShowsApi {
    @GET("schedule")
    fun getShows(): Call<AnimeList>;
    @GET("anime/{id}")
    fun getShowDetails(
        @Path("id") showId: String): Call<AnimeDetails>
}