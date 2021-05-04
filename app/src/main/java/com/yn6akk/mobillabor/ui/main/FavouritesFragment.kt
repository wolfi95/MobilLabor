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

class FavouritesFragment : Fragment(), FavouritesScreen {
    @Inject
    lateinit var favPresenter: FavouritesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        favPresenter.attachScreen(this)
        val dbThread = Thread {
            val shows = favPresenter.getFavShows(context)
            this.activity?.runOnUiThread {
                Log.d("here",shows.first().toString())
            }
        }
        dbThread.start()
    }

    override fun onDetach() {
        favPresenter.detachScreen()
        super.onDetach()
    }

    companion object {
        fun newInstance(): FavouritesFragment {
            val fragment = FavouritesFragment()
            return fragment
        }
    }
}