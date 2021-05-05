package com.yn6akk.mobillabor.test

import android.os.Looper
import com.yn6akk.mobillabor.testInjector
import com.yn6akk.mobillabor.ui.details.DetailsPresenter
import com.yn6akk.mobillabor.ui.details.DetailsScreen
import com.yn6akk.mobillabor.utils.argumentCaptor
import com.yn6akk.mobillabor.utils.capture
import com.yn6akk.mobillabor.utils.mock
import io.swagger.client.models.AnimeDetails
import io.swagger.client.models.AnimeList
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito
import org.robolectric.RobolectricTestRunner
import org.robolectric.Shadows
import org.robolectric.annotation.Config
import org.robolectric.annotation.LooperMode
import javax.inject.Inject
import kotlin.jvm.Throws

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [28])
@LooperMode(LooperMode.Mode.PAUSED)
class DetailsTest {
    @Inject
    lateinit var detailsPresenter: DetailsPresenter
    private lateinit var detailsScreen: DetailsScreen

    @Throws(Exception::class)
    @Before
    fun setup() {
        testInjector.inject(this)
        detailsScreen = mock()
        detailsPresenter.attachScreen(detailsScreen)
    }

    @Test
    fun testDetailsSearch() {
        detailsPresenter.getShowDetails("0");

        val details = argumentCaptor<AnimeDetails>()
        Shadows.shadowOf(Looper.getMainLooper()).idle();
        Mockito.verify(detailsScreen).showDetails(capture(details))
        assert(details.value.title == "Details Test 1")
    }

    @Test
    fun testWrongIdSearch() {
        detailsPresenter.getShowDetails("1");

        val error = argumentCaptor<String>()
        Shadows.shadowOf(Looper.getMainLooper()).idle();
        Mockito.verify(detailsScreen).showNetworkError(capture(error))
    }

    @After
    fun tearDown() {
        detailsPresenter.detachScreen()
    }
}