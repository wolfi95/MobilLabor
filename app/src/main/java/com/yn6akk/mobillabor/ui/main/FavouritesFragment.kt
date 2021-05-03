package com.yn6akk.mobillabor.ui.main

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.ui.injector
import io.swagger.client.models.AnimeList
import javax.inject.Inject

class FavouritesFragment : Fragment(), MainScreen {
    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        mainPresenter.attachScreen(this)
        val dbThread = Thread {
            val shows = mainPresenter.getFavShows(context)
            this.activity?.runOnUiThread {
                Log.d("here",shows.first().toString())
            }
        }
        dbThread.start()
    }

    override fun onDetach() {
        mainPresenter.detachScreen()
        super.onDetach()
    }

    override fun showShows(shows: AnimeList?) {
        TODO("Not yet implemented")
    }

    override fun showNetworkError(errorMsg: String) {
        TODO("Not yet implemented")
    }

    companion object {
        fun newInstance(): FavouritesFragment {
            val fragment = FavouritesFragment()
            return fragment
        }
    }
}