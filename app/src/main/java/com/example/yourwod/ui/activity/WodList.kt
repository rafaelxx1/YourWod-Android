package com.example.yourwod.ui.activity

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.dao.DaoWod
import com.example.yourwod.databinding.WodListActivityBinding
import com.example.yourwod.ui.recyclerview.adapter.WodListAdapter


class WodList : AppCompatActivity() {

    private val binding by lazy {WodListActivityBinding.inflate(layoutInflater) }
    private val dao = DaoWod()
    private val adapter = WodListAdapter(this, dao.getAllWods())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureRecyclerView()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAllWods())
        btnBack()
        btnAddWod()
    }


    private fun configureRecyclerView(){
        val recyclerView = binding.recyclerWodList
        recyclerView.adapter = adapter
    }



    private fun btnBack() {
        val btnBack = binding.btnBack
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun btnAddWod(){
        val btnAddWod = binding.btnForm
        btnAddWod.setOnClickListener {
            goToFormAddWod()
        }
    }

    private fun goToFormAddWod(){
        val intent = Intent(this, FormAddWod::class.java)
        startActivity(intent)
    }

}