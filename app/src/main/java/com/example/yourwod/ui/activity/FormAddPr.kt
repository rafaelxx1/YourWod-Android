package com.example.yourwod.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.yourwod.R
import com.example.yourwod.dao.DaoPr
import com.example.yourwod.model.Pr
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class FormAddPr : AppCompatActivity(R.layout.form_add_pr) {

    private var weightInt: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnSave()
    }

    private fun btnSave(){
        val btnSave = findViewById<Button>(R.id.btnSave_pr)
        btnSave.setOnClickListener {
            val dao = DaoPr()
            dao.addPr(createPr())
            finish()
        }
    }

    private fun createPr(): Pr{
        val edCategory = findViewById<EditText>(R.id.edCategory_pr)
        val category = edCategory.text.toString()

        val edWeight = findViewById<EditText>(R.id.edWeight_pr)
        val weightString = edWeight.text.toString()
        try {
            this.weightInt = weightString.toInt()
        } catch (e: NumberFormatException) {
            Log.i("TRY TO MODIFY TO INT", "Error: $e --- $weightString --- $weightInt")
        }


        val edDate = findViewById<EditText>(R.id.edDate_pr)
        val dateString = edDate.text.toString()
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val date = LocalDate.parse(dateString, dateFormatter)

        return Pr(
            category = category,
            weight = weightInt,
            date = date
        )
    }
}