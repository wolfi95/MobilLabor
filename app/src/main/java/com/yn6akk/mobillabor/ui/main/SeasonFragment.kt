package com.yn6akk.mobillabor.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.model.Show
import com.yn6akk.mobillabor.ui.details.DetailsActivity
import com.yn6akk.mobillabor.ui.injector
import kotlinx.android.synthetic.main.fragment_season.view.*
import javax.inject.Inject

class SeasonFragment : Fragment(), MainScreen {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_season, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.button.setOnClickListener {
            val intent = Intent(getActivity(), DetailsActivity::class.java)
            startActivity(intent)
        }
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

    override fun showShows(shows: List<Show>?) {
        TODO("Not yet implemented")
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