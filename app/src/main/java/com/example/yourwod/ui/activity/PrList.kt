package com.example.yourwod.ui.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.yourwod.R
import com.example.yourwod.dao.DaoPr
import com.example.yourwod.databinding.PrListActivityBinding
import com.example.yourwod.ui.recyclerview.adapter.PrListAdapter

class PrList : AppCompatActivity() {

    private val binding by lazy {PrListActivityBinding.inflate(layoutInflater)}
    private val dao = DaoPr()
    private val adapter = PrListAdapter(this, dao.getAllPr())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureRecylerView()
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        adapter.update(dao.getAllPr())
        btnAddPr()
        btnBack()
    }

    private fun configureRecylerView(){
        val recyclerView = binding.prListRecyclerView
        recyclerView.adapter = this.adapter
    }

    private fun btnAddPr(){
        val btnAddPr = binding.btnFormPr
        btnAddPr.setOnClickListener {
            goToFormAddPr()
        }
    }

    private fun btnBack(){
        val btnBack = binding.btnBackPrList
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun goToFormAddPr(){
        val intent = Intent(this, FormAddPr::class.java)
        startActivity(intent)
    }
}