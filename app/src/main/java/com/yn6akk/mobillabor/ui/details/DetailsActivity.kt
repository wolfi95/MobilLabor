package com.yn6akk.mobillabor.ui.details

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.ui.injector
import com.yn6akk.mobillabor.ui.main.MainActivity
import io.swagger.client.models.AnimeDetails
import javax.inject.Inject

class DetailsActivity : AppCompatActivity(), DetailsScreen {

    @Inject
    lateinit var detailPresenter: DetailsPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
        injector.inject(this)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }

    override fun onSupportNavigateUp(): Boolean {
        val intent = Intent(this, MainActivity::class.java)
        this.startActivity(intent)
        return true
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
        val id = intent.getIntExtra("id",0);
        detailPresenter.getShowDetails(id.toString())
    }

    override fun showDetails(show: AnimeDetails) {
        findViewById<TextView>(R.id.detailsTitle)?.text = show.title
        val pic = findViewById<ImageView>(R.id.picture)
        Glide.with(this).load(show.image_url).into(pic)
        findViewById<TextView>(R.id.synopsis)?.text = show.synopsis
        val episodesContainer = findViewById<LinearLayout>(R.id.episodesContainer)
        for(i in 0..show.episodes!!) {
            val textView: TextView = TextView(this)
            textView.text = "Episode " + i
            episodesContainer.addView(textView)
        }
    }

    override fun showNetworkError(errorMsg: String) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show()
    }
}