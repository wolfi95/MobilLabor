package com.yn6akk.mobillabor.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yn6akk.mobillabor.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction().replace(R.id.seasonFragment, SeasonFragment.newInstance()).commit()
    }
}