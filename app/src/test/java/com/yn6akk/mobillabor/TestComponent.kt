package com.yn6akk.mobillabor

import com.yn6akk.mobillabor.interactor.InteractorModule
import com.yn6akk.mobillabor.mock.MockNetworkModule
import com.yn6akk.mobillabor.test.DetailsTest
import com.yn6akk.mobillabor.test.ScheduleTest
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MockNetworkModule::class, TestModule::class, InteractorModule::class])
interface TestComponent : MobilLaborApplicationComponent {
    fun inject(scheduleTest: ScheduleTest)
    fun inject(detailsTest: DetailsTest)
}
