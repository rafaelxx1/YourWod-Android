package com.example.yourwod.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.dao.DaoPr
import com.example.yourwod.ui.recyclerview.adapter.PrListAdapter

class PrList : AppCompatActivity(R.layout.pr_list_activity) {

    private val dao = DaoPr()
    private val adapter = PrListAdapter(this, dao.getAllPr())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureRecylerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAllPr())
        btnAddPr()
    }

    private fun configureRecylerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.pr_list_recycler_view)
        recyclerView.adapter = this.adapter
    }

    private fun btnAddPr(){
        val btnAddPr = findViewById<Button>(R.id.btnForm_pr)
        btnAddPr.setOnClickListener {
            goToFormAddPr()
        }
    }

    private fun goToFormAddPr(){
        val intent = Intent(this, FormAddPr::class.java)
        startActivity(intent)
    }
}