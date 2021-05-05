package com.yn6akk.mobillabor.test

import android.os.Looper.getMainLooper
import com.yn6akk.mobillabor.testInjector
import com.yn6akk.mobillabor.ui.main.MainPresenter
import com.yn6akk.mobillabor.ui.main.ScheduleScreen
import com.yn6akk.mobillabor.utils.argumentCaptor
import com.yn6akk.mobillabor.utils.mock
import io.swagger.client.models.Anime
import io.swagger.client.models.AnimeList
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.mockito.Mockito.verify
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows.shadowOf
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import java.util.ArrayList
import javax.inject.Inject
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
@LooperMode(LooperMode.Mode.PAUSED)
class ScheduleTest {
    @Inject
    lateinit var mainPresenter: MainPresenter
    private lateinit var mainScreen: ScheduleScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        mainScreen = mock()
        mainPresenter.attachScreen(mainScreen)
    }

    @Test
    fun testShows() {
        mainPresenter.refreshShows()

        val list = argumentCaptor<AnimeList>()
        shadowOf(getMainLooper()).idle();
        verify(mainScreen).showShows(list.capture())
        assert(!list.value.monday.isNullOrEmpty())
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}