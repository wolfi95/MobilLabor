package com.yn6akk.mobillabor.mock

import com.yn6akk.mobillabor.network.ShowsApi
import io.swagger.client.models.Anime
import io.swagger.client.models.AnimeDetails
import io.swagger.client.models.AnimeList
import okhttp3.MediaType
import okhttp3.Request
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query
import java.io.IOException
import java.util.ArrayList
import kotlin.jvm.Throws

class MockShowsApi : ShowsApi {
    override fun getShows(): Call<AnimeList> {
        val showsResult = AnimeList();
        val show = Anime(title = "Test1", mal_id = 0)
        val monday = ArrayList<Anime>()
        monday.add(show)

        showsResult.monday = monday.toTypedArray()

        val call = object : Call<AnimeList> {
            @Throws(IOException::class)
            override fun execute(): Response<AnimeList> {
                return Response.success(showsResult)
            }

            override fun enqueue(callback: Callback<AnimeList>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<AnimeList> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

    override fun getShowDetails(showId: String): Call<AnimeDetails> {
        val detailsResult = AnimeDetails()

        detailsResult.title = "Details Test 1"
        detailsResult.synopsis = "This is the synopsis of Details Test 1"
        detailsResult.mal_id = 0

        val call = object : Call<AnimeDetails> {
            @Throws(IOException::class)
            override fun execute(): Response<AnimeDetails> {
                if(showId.toInt() == detailsResult.mal_id) {
                    return Response.success(detailsResult)
                } else {
                    return Response.error(400, ResponseBody.create(MediaType.get("application/json"), "Couldnt find details."))
                }
            }

            override fun enqueue(callback: Callback<AnimeDetails>) {

            }

            override fun isExecuted(): Boolean {
                return false
            }

            override fun cancel() {

            }

            override fun isCanceled(): Boolean {
                return false
            }

            override fun clone(): Call<AnimeDetails> {
                return this
            }

            override fun request(): Request? {
                return null
            }
        }

        return call
    }

}