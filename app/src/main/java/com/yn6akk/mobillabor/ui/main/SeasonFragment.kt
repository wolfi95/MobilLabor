package com.yn6akk.mobillabor.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.model.ScheduleDay
import com.yn6akk.mobillabor.ui.injector
import io.swagger.client.models.AnimeList
import kotlinx.android.synthetic.main.fragment_season.*
import javax.inject.Inject

class SeasonFragment : Fragment(), ScheduleScreen {
    private var seasonsAdapter: SeasonsAdapter? = null
    private val displayedDays: MutableList<ScheduleDay> = mutableListOf()

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_season, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val llm = LinearLayoutManager(context)
        llm.orientation = LinearLayoutManager.VERTICAL
        recyclerViewDays.layoutManager = llm
        seasonsAdapter = SeasonsAdapter(context!!, displayedDays)
        recyclerViewDays.adapter = seasonsAdapter
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        injector.inject(this)
        mainPresenter.attachScreen(this)
    }

    override fun onDetach() {
        mainPresenter.detachScreen()
        super.onDetach()
    }

    override fun onResume() {
        super.onResume()
        mainPresenter.refreshShows()
    }

    override fun showShows(shows: AnimeList?) {
        displayedDays.clear()
        val days: MutableList<ScheduleDay> = mutableListOf()
        days.add(ScheduleDay(name = "Monday", shows = shows?.monday))
        days.add(ScheduleDay(name = "Tuesday", shows = shows?.tuesday))
        days.add(ScheduleDay(name = "Wednesday", shows = shows?.wednesday))
        days.add(ScheduleDay(name = "Thursday", shows = shows?.thursday))
        days.add(ScheduleDay(name = "Friday", shows = shows?.friday))
        days.add(ScheduleDay(name = "Saturday", shows = shows?.saturday))
        days.add(ScheduleDay(name = "Sunday", shows = shows?.sunday))

        if(shows != null) {
            displayedDays.addAll(days)
        }

        seasonsAdapter?.notifyDataSetChanged()
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(context, errorMsg, Toast.LENGTH_LONG).show()
    }

    companion object {
        fun newInstance(): SeasonFragment {
            val fragment = SeasonFragment()
            return fragment
        }
    }
}