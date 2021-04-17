package com.yn6akk.mobillabor.network

import com.yn6akk.mobillabor.model.ShowDetailsResult
import com.yn6akk.mobillabor.model.ShowsResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ShowsApi {
    @GET("search")
    fun getShows(): Call<ShowsResult>;
    @GET("details")
    fun getShowDetails(
        @Query("id") showId: String): Call<ShowDetailsResult>
}