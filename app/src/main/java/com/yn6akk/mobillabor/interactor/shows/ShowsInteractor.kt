package com.yn6akk.mobillabor.interactor.shows

import android.util.Log
import com.yn6akk.mobillabor.interactor.shows.events.GetShowsEvent
import com.yn6akk.mobillabor.network.ShowsApi
import org.greenrobot.eventbus.EventBus
import java.lang.Exception
import javax.inject.Inject

class ShowsInteractor @Inject constructor(private var showsApi: ShowsApi) {

    fun getShows(){
        val event = GetShowsEvent();

        try {
            val showsQueryCall = showsApi.getShows();
            val response = showsQueryCall.execute();
            Log.d("Response", response.body().toString());

            if(response.code() != 200) {
                throw Exception("Couldnt get shows.")
            }
            event.code = response.code()
            event.shows = response.body()?.shows?.items
            EventBus.getDefault().post(event)
        } catch (e: Exception) {
            event.throwable = e;
            EventBus.getDefault().post(event);
        }
    }
}