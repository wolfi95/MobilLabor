package com.yn6akk.mobillabor

import android.app.Application
import androidx.multidex.MultiDexApplication
import com.yn6akk.mobillabor.ui.UIModule

class MobilLaborApplication : MultiDexApplication() {
    lateinit var injector: MobilLaborApplicationComponent

    override fun onCreate() {

        super.onCreate()
        injector = DaggerMobilLaborApplicationComponent.builder().uIModule(UIModule(this)).build()
    }
}