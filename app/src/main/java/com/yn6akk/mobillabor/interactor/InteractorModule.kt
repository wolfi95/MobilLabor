package com.yn6akk.mobillabor.interactor

//import com.yn6akk.mobillabor.interactor.api.ApiInteractor
//import com.yn6akk.mobillabor.persistence.PersistenceInteractor
import com.yn6akk.mobillabor.interactor.shows.ShowsInteractor
import com.yn6akk.mobillabor.network.ShowsApi
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class InteractorModule {
    @Provides
    @Singleton
    fun provideShowsInteractor(showsApi: ShowsApi) = ShowsInteractor(showsApi)
}