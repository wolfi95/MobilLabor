package com.yn6akk.mobillabor

import com.yn6akk.mobillabor.interactor.InteractorModule
import com.yn6akk.mobillabor.network.NetworkModule
import com.yn6akk.mobillabor.ui.UIModule
import com.yn6akk.mobillabor.ui.details.DetailsActivity
import com.yn6akk.mobillabor.ui.main.FavouritesFragment
import com.yn6akk.mobillabor.ui.main.MainActivity
import com.yn6akk.mobillabor.ui.main.SeasonFragment
import javax.inject.Singleton
import dagger.Component

@Singleton
@Component(modules = [UIModule::class, NetworkModule::class, InteractorModule::class])
interface MobilLaborApplicationComponent {
    fun inject(seasonFragment: SeasonFragment)
    fun inject(favouritesFragment: FavouritesFragment)
    fun inject(detailsActivity: DetailsActivity)
}