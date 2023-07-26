package com.example.yourwod.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.model.Pr

class PrListAdapter(
    private val context: Context,
    prs: List<Pr>
) : RecyclerView.Adapter<PrListAdapter.ViewH>(){
    private val prs = prs.toMutableList()

    class ViewH(view: View) : RecyclerView.ViewHolder(view){
        fun putIt(pr: Pr){
            val category = itemView.findViewById<TextView>(R.id.tvPr_category)
            category.text = pr.category

            val weight = itemView.findViewById<TextView>(R.id.tvPr_weight)
            weight.text = pr.weight.toString()

            val date = itemView.findViewById<TextView>(R.id.tvPr_date)
            date.text = pr.date.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewH {

        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.pr_info_activity, parent, false)
        return ViewH(view)
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