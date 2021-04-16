package com.yn6akk.mobillabor.ui

import android.app.Activity
import androidx.fragment.app.Fragment
import com.yn6akk.mobillabor.MobilLaborApplication
import com.yn6akk.mobillabor.MobilLaborApplicationComponent

val Activity.injector: MobilLaborApplicationComponent
    get() {
        return (this.applicationContext as MobilLaborApplication).injector
    }

val Fragment.injector: MobilLaborApplicationComponent
    get() {
        return (this.context!!.applicationContext as MobilLaborApplication).injector
    }