package com.example.yourwod.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.model.Wod

class WodListAdapter(
    private val context: Context,
    wods: List<Wod>
) : RecyclerView.Adapter<WodListAdapter.ViewH>() {
    private val wods = wods.toMutableList()

    class ViewH(view: View) : RecyclerView.ViewHolder(view){
        fun putIt(wod: Wod){
            val title = itemView.findViewById<TextView>(R.id.tvWodCard_tittle)
            title.text = wod.wodTitle

            val workout = itemView.findViewById<TextView>(R.id.tvWodCard_wod)
            workout.text = wod.wod

            val timeWod = itemView.findViewById<TextView>(R.id.tvWodCard_time)
            timeWod.text = wod.wodTime.toString()

            val dateWod = itemView.findViewById<TextView>(R.id.tvWodCard_date)
            dateWod.text = wod.wodDate.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewH {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.athlete_wod_info_activity, parent, false)
        return ViewH(view)
    }

    override fun getItemCount(): Int {
        return wods.size
    }

    override fun onBindViewHolder(holder: ViewH, position: Int) {
        val wod = wods[position]
        holder.putIt(wod)
    }

    fun update(wods: List<Wod>){
        this.wods.clear()
        this.wods.addAll(wods)
        notifyDataSetChanged()
    }
}
