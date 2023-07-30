package com.example.yourwod.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.yourwod.R
import com.example.yourwod.dao.DaoPr
import com.example.yourwod.databinding.FormAddPrBinding
import com.example.yourwod.model.Pr
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FormAddPr : AppCompatActivity() {

    private val binding by lazy { FormAddPrBinding.inflate(layoutInflater)}
    private var weightInt: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnSave()
        btnBack()
        setContentView(binding.root)
    }

    private fun btnSave(){
        val btnSave = binding.btnSavePr
        btnSave.setOnClickListener {
            val dao = DaoPr()
            dao.addPr(createPr())
            finish()
        }
    }

    private fun btnBack(){
        val btnBack = binding.btnBackPr
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun createPr(): Pr{
        val category = binding.edCategoryPr.text.toString()
        val weightString = binding.edWeightPr.text.toString()
        try {
            this.weightInt = weightString.toInt()
        } catch (e: NumberFormatException) {
            Log.i("TRY TO MODIFY TO INT", "Error: $e --- $weightString --- $weightInt")
        }

        val dateString = binding.edDatePr.text.toString()
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val date = LocalDate.parse(dateString, dateFormatter)

        return Pr(
            category = category,
            weight = weightInt,
            date = date
        )
    }
}