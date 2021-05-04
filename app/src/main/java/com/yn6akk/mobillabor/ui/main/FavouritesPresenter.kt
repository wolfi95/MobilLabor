package com.yn6akk.mobillabor.ui.main

import android.content.Context
import com.yn6akk.mobillabor.interactor.shows.ShowsInteractor
import com.yn6akk.mobillabor.persistence.Database
import com.yn6akk.mobillabor.persistence.models.PersistedShow
import com.yn6akk.mobillabor.ui.Presenter
import org.greenrobot.eventbus.EventBus
import java.util.concurrent.Executor
import javax.inject.Inject

class FavouritesPresenter @Inject constructor(private val executor: Executor, private val showsInteractor: ShowsInteractor) : Presenter<FavouritesScreen>()  {
    override fun attachScreen(screen: FavouritesScreen) {
        super.attachScreen(screen)
        /*if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }*/
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun getFavShows(context: Context): List<PersistedShow> {
        return Database.getDatabase(context).favouritesdDao().getAllFavourites()
    }
}