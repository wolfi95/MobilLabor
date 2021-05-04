package com.yn6akk.mobillabor.ui.main

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.persistence.models.PersistedShow


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SeasonFragment.newInstance(), "seasons_fragment").commit()
        val newShow = PersistedShow("firstShow", 0);
        /*try {
            var dbThread = Thread {
                Database.getDatabase(this).favouritesdDao().addFavourite(newShow)
            }
            dbThread.start()
        } catch (e: Exception) {
            Log.e("insert",e.toString())
        }*/
        val buttonOne = findViewById<Button>(R.id.seasonsButton);
        buttonOne.setOnClickListener {
            val myFragment: SeasonFragment? =
                supportFragmentManager.findFragmentByTag("seasons_fragment") as SeasonFragment?
            if (myFragment == null) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SeasonFragment.newInstance(),"seasons_fragment").commit()
            }
        }
        val buttonTwo = findViewById<Button>(R.id.favouritesButton);
        buttonTwo.setOnClickListener {
            val myFragment: FavouritesFragment? =
                supportFragmentManager.findFragmentByTag("fav_fragment") as FavouritesFragment?
            if (myFragment == null) {
                supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FavouritesFragment.newInstance(), "fav_fragment").commit()
            }
        }
    }
}