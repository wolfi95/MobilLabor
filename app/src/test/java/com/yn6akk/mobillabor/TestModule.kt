package com.yn6akk.mobillabor

import android.content.Context
import com.yn6akk.mobillabor.interactor.shows.ShowsInteractor
import com.yn6akk.mobillabor.ui.main.FavouritesPresenter
import com.yn6akk.mobillabor.ui.main.MainPresenter
import com.yn6akk.mobillabor.utils.UiExecutor
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executor
import javax.inject.Singleton

@Module
class TestModule(private val context: Context) {

    @Provides
    fun provideContext() = context

    @Provides
    @Singleton
    fun provideMainPresenter(executor: Executor, showsInteractor: ShowsInteractor) = MainPresenter(executor, showsInteractor)

    @Provides
    @Singleton
    fun provideFavouritesPresenter(executor: Executor, showsInteractor: ShowsInteractor) = FavouritesPresenter(executor, showsInteractor)

    @Provides
    @Singleton
    fun provideNetworkExecutor(): Executor = UiExecutor()
}
