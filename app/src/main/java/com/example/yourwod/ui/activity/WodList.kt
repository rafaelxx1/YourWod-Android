package com.example.yourwod.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.dao.DaoWod
import com.example.yourwod.ui.recyclerview.adapter.WodListAdapter


class WodList : AppCompatActivity(R.layout.wod_list_activity) {

    private val dao = DaoWod()
    private val adapter = WodListAdapter(this, dao.getAllWods())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureRecyclerView()
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAllWods())
        btnBack()
        btnAddWod()
    }


    private fun configureRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_wod_list)
        recyclerView.adapter = adapter
    }



    private fun btnBack() {
        val btnBack = findViewById<Button>(R.id.btn_back)
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun btnAddWod(){
        val btnAddWod = findViewById<Button>(R.id.btn_form)
        btnAddWod.setOnClickListener {
            goToFormAddWod()
        }
    }

    private fun goToFormAddWod(){
        val intent = Intent(this, FormAddWod::class.java)
        startActivity(intent)
    }

}