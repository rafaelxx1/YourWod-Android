package com.example.yourwod.ui.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.ui.text.intl.Locale
import com.example.yourwod.R
import com.example.yourwod.dao.DaoWod
import com.example.yourwod.model.Wod
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class FormAddWod : AppCompatActivity(R.layout.form_add_wod) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnBack()
        btnSave()
    }


    private fun btnBack() {
        val btnBack = findViewById<Button>(R.id.btnFormWod_back)
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun btnSave() {
        val btnSave = findViewById<Button>(R.id.btnFormWod_save_wod)
        val dao = DaoWod()
        btnSave.setOnClickListener {
            val newWod = createWod()
            dao.addWod(newWod)
            finish()
        }
    }

    private fun createWod(): Wod {
        val edTitle = findViewById<EditText>(R.id.etFormWod_title_wod)
        val title = edTitle.text.toString()

        val edWorkout = findViewById<EditText>(R.id.etFormWod_wod)
        val workout = edWorkout.text.toString()

        val edTime = findViewById<EditText>(R.id.etFormWod_time_wod)
        val timeString = edTime.text.toString()
        val formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss") // Formato da hora (24 horas)
        val time = LocalTime.parse(timeString, formatterTime)

        val edDate = findViewById<EditText>(R.id.etFormWod_date_wod)
        val dateString = edDate.text.toString()
        val dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
        val date = LocalDate.parse(dateString, dateFormatter)

        return Wod(
            wodTitle = title,
            wod = workout,
            wodTime = time,
            wodDate = date
        )
    }

}