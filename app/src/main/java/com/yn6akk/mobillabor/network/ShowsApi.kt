package com.yn6akk.mobillabor.network

import com.yn6akk.mobillabor.model.ShowsResult
import retrofit2.Call
import retrofit2.http.GET

interface ShowsApi {
    @GET("search")
    fun getShows(): Call<ShowsResult>;
}