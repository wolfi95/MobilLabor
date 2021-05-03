package com.yn6akk.mobillabor.interactor.shows

import android.util.Log
import com.yn6akk.mobillabor.interactor.shows.events.GetShowDetailsEvent
import com.yn6akk.mobillabor.interactor.shows.events.GetShowsEvent
import com.yn6akk.mobillabor.network.ShowsApi
import com.yn6akk.mobillabor.persistence.Database
import org.greenrobot.eventbus.EventBus
import java.lang.Exception
import javax.inject.Inject

class ShowsInteractor @Inject constructor(private var showsApi: ShowsApi) {

    fun getShows(){
        val event = GetShowsEvent();

        try {
            val showsQueryCall = showsApi.getShows();
            val response = showsQueryCall.execute();

            if(response.code() != 200) {
                throw Exception("Couldnt get shows.")
            }
            event.code = response.code()
            event.data = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e;
            EventBus.getDefault().post(event);
        }
    }

    fun getShowDetails(showId: String) {
        val event = GetShowDetailsEvent();

        try {
            val showDetailsQueryCall = showsApi.getShowDetails(showId);
            val response = showDetailsQueryCall.execute();

            if(response.code() != 200) {
                throw Exception("Couldnt get show details.")
            }
            event.code = response.code()
            event.showDetails = response.body()
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e;
            EventBus.getDefault().post(event);
        }
    }
}