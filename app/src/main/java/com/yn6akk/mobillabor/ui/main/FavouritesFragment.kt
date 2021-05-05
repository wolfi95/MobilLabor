package com.yn6akk.mobillabor.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.model.ScheduleDay
import com.yn6akk.mobillabor.ui.injector
import io.swagger.client.models.Anime
import kotlinx.android.synthetic.main.fragment_favourites.*
import kotlinx.android.synthetic.main.fragment_season.*
import javax.inject.Inject

class FavouritesFragment : Fragment(), FavouritesScreen {
    private var favAdapter: FavouritesAdapter? = null
    private val displayedDays: MutableList<ScheduleDay> = mutableListOf()

    @Inject
    lateinit var favPresenter: FavouritesPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_favourites, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewFavs.layoutManager = llm
        favAdapter = FavouritesAdapter(context!!, displayedDays)
        recyclerViewFavs.adapter = favAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        favPresenter.attachScreen(this)
        val dbThread = Thread {
            val shows = favPresenter.getFavShows(context)
            this.activity?.runOnUiThread {
                displayedDays.clear()
                val days: MutableList<ScheduleDay> = mutableListOf()
                days.add(ScheduleDay(name = "Monday", shows = shows.filter { it.airsOn == "Monday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))
                days.add(ScheduleDay(name = "Tuesday", shows = shows.filter { it.airsOn == "Tuesday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))
                days.add(ScheduleDay(name = "Wednesday", shows = shows.filter { it.airsOn == "Wednesday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))
                days.add(ScheduleDay(name = "Thursday", shows = shows.filter { it.airsOn == "Thursday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))
                days.add(ScheduleDay(name = "Friday", shows = shows.filter { it.airsOn == "Friday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))
                days.add(ScheduleDay(name = "Saturday", shows = shows.filter { it.airsOn == "Saturday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))
                days.add(ScheduleDay(name = "Sunday", shows = shows.filter { it.airsOn == "Sunday" }.map{ Anime(mal_id = it.id, title = it.title ) }.toTypedArray()))

                for(i in days) {
                    if(!i.shows.isNullOrEmpty())
                        displayedDays.add(i)
                }

                favAdapter?.notifyDataSetChanged()
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