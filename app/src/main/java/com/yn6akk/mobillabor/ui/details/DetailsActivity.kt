package com.yn6akk.mobillabor.ui.details

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.ui.injector
import com.yn6akk.mobillabor.ui.main.SeasonFragment
import io.swagger.client.models.AnimeDetails
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsScreen {

    @Inject
    lateinit var detailPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        injector.inject(this)
    }

    override fun onStart() {
        super.onStart()
        detailPresenter.attachScreen(this)
    }

    override fun onStop() {
        super.onStop()
        detailPresenter.detachScreen()
    }

    override fun onResume() {
        super.onResume()
        detailPresenter.getShowDetails("selectedArtist")
    }

    override fun showDetails(shows: AnimeDetails) {
        TODO("Not yet implemented")
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }
}