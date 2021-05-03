package com.yn6akk.mobillabor.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.persistence.models.PersistedShow


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SeasonFragment.newInstance()).commit()
        val newShow = PersistedShow("firstShow", 0);
        /*try {
            var dbThread = Thread {
                Database.getDatabase(this).favouritesdDao().addFavourite(newShow)
            }
            dbThread.start()
        } catch (e: Exception) {
            Log.e("insert",e.toString())
        }*/
        val buttonOne = findViewById<Button>(R.id.button2);
        buttonOne.setOnClickListener {
            Log.d("frag","season")
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, SeasonFragment.newInstance()).commit()
        }
        val buttonTwo = findViewById<Button>(R.id.button3);
        buttonTwo.setOnClickListener {
            Log.d("frag","fav")
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, FavouritesFragment.newInstance()).commit()
        }
    }
}