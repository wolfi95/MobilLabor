package com.yn6akk.mobillabor.test

import com.yn6akk.mobillabor.testInjector
import com.yn6akk.mobillabor.ui.main.MainPresenter
import com.yn6akk.mobillabor.ui.main.ScheduleScreen
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
import java.util.ArrayList
import javax.inject.Inject
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
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
    fun testSearch() {
        val showsResult = AnimeList();
        val show = Anime(title = "Test1", mal_id = 0)
        val monday = ArrayList<Anime>()
        monday.add(show)

        showsResult.monday = monday.toArray() as Array<Anime>?
        mainPresenter.refreshShows()
        verify(mainScreen).showShows(showsResult)
    }

    @After
    fun tearDown() {
        mainPresenter.detachScreen()
    }
}