package com.yn6akk.mobillabor.ui.main

import com.yn6akk.mobillabor.interactor.shows.ShowsInteractor
import com.yn6akk.mobillabor.interactor.shows.events.GetShowsEvent
import com.yn6akk.mobillabor.model.Show
import com.yn6akk.mobillabor.ui.Presenter
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class MainPresenter @Inject constructor(private val executor: Executor, private val showsInteractor: ShowsInteractor) : Presenter<MainScreen>() {

    override fun attachScreen(screen: MainScreen) {
        super.attachScreen(screen)
        EventBus.getDefault().register(this)
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun refreshShows() {
        executor.execute {
            showsInteractor.getShows()
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetShowsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.shows != null) {
                    screen?.showShows(event.shows as MutableList<Show>)
                }

            }
        }
    }
}