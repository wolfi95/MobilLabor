package com.yn6akk.mobillabor.ui.details

import com.yn6akk.mobillabor.interactor.shows.ShowsInteractor
import com.yn6akk.mobillabor.interactor.shows.events.GetShowDetailsEvent
import com.yn6akk.mobillabor.ui.Presenter
import io.swagger.client.models.AnimeDetails
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode
import java.util.concurrent.Executor
import javax.inject.Inject

class DetailsPresenter @Inject constructor(private val executor: Executor, private val showsInteractor: ShowsInteractor) : Presenter<DetailsScreen>() {

    override fun attachScreen(screen: DetailsScreen) {
        super.attachScreen(screen)
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this)
        }
    }

    override fun detachScreen() {
        EventBus.getDefault().unregister(this)
        super.detachScreen()
    }

    fun getShowDetails(showId: String) {
        executor.execute {
            showsInteractor.getShowDetails(showId);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    fun onEventMainThread(event: GetShowDetailsEvent) {
        if (event.throwable != null) {
            event.throwable?.printStackTrace()
            if (screen != null) {
                screen?.showNetworkError(event.throwable?.message.orEmpty())
            }
        } else {
            if (screen != null) {
                if (event.showDetails != null) {
                    screen?.showDetails(event.showDetails as AnimeDetails)
                }

            }
        }
    }
}