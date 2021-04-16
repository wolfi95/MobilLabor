package com.yn6akk.mobillabor

import android.app.Application
import com.yn6akk.mobillabor.ui.UIModule

class MobilLaborApplication : Application() {
    lateinit var injector: MobilLaborApplicationComponent

    override fun onCreate() {
        super.onCreate()
        injector = DaggerMobilLaborApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}