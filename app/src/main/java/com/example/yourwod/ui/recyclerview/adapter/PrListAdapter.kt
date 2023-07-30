package com.example.yourwod.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.databinding.PrInfoActivityBinding
import com.example.yourwod.model.Pr

class PrListAdapter(
    private val context: Context,
    prs: List<Pr>
) : RecyclerView.Adapter<PrListAdapter.ViewH>(){
    private val prs = prs.toMutableList()

    class ViewH(binding: PrInfoActivityBinding) : RecyclerView.ViewHolder(binding.root){

        private val category = binding.tvPrCategory
        private val weight = binding.tvPrWeight
        private val date = binding.tvPrDate
        fun putIt(pr: Pr){
            category.text = pr.category

            weight.text = pr.weight.toString()

            date.text = pr.date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewH {
        val binding = PrInfoActivityBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewH(binding)
    }

    override fun getItemCount(): Int {
        return prs.size
    }

    override fun onBindViewHolder(holder: ViewH, position: Int) {
        val prs = prs[position]
        holder.putIt(prs)
    }

    fun update(prs: List<Pr>){
        this.prs.clear()
        this.prs.addAll(prs)
        notifyDataSetChanged()
    }

}