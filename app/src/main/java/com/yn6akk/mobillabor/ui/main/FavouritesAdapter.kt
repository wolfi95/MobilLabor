package com.yn6akk.mobillabor.ui.main

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.yn6akk.mobillabor.R
import com.yn6akk.mobillabor.model.ScheduleDay
import com.yn6akk.mobillabor.ui.details.DetailsActivity
import kotlinx.android.synthetic.main.card_schedule_day.view.*

class FavouritesAdapter constructor(
        private val context: Context,
        private var scheduleDays: List<ScheduleDay>) : RecyclerView.Adapter<FavouritesAdapter.ViewHolder>() {


    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.card_schedule_day, viewGroup, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val day = scheduleDays[position]

        holder.tvDayName.text = day.name

        for (i in day.shows!!) {
            val textView: TextView = TextView(context)
            textView.text = i.title
            textView.setPadding(0,0, 0, 10)
            textView.setOnClickListener {
                val intent = Intent(context, DetailsActivity::class.java)
                intent.putExtra("id",i.mal_id)
                context.startActivity(intent)
            }
            holder.containerShows.addView(textView)
        }
    }

    override fun getItemCount() = scheduleDays.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var tvDayName: TextView = view.dayName
        var containerShows: LinearLayout = view.showsContainer
    }
}