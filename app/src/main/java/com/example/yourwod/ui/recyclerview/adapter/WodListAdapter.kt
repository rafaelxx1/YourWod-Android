package com.example.yourwod.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.databinding.AthleteWodInfoActivityBinding
import com.example.yourwod.model.Wod

class WodListAdapter(
    private val context: Context,
    wods: List<Wod>
) : RecyclerView.Adapter<WodListAdapter.ViewH>() {
    private val wods = wods.toMutableList()

    class ViewH(binding: AthleteWodInfoActivityBinding) : RecyclerView.ViewHolder(binding.root) {

        private val title = binding.tvWodCardTittle
        private val workout = binding.tvWodCardWod
        private val timeWod = binding.tvWodCardTime
        private val dateWod = binding.tvWodCardDate
        fun putIt(wod: Wod) {
            title.text = wod.wodTitle

            workout.text = wod.wod

            timeWod.text = wod.wodTime.toString()

            dateWod.text = wod.wodDate.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewH {
        val binding = AthleteWodInfoActivityBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewH(binding)
    }

    override fun getItemCount(): Int {
        return wods.size
    }

    override fun onBindViewHolder(holder: ViewH, position: Int) {
        val wod = wods[position]
        holder.putIt(wod)
    }

    fun update(wods: List<Wod>) {
        this.wods.clear()
        this.wods.addAll(wods)
        notifyDataSetChanged()
    }
}
