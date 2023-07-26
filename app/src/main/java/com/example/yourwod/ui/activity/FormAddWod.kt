package com.example.yourwod.ui.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
    private var time: LocalTime = LocalTime.now()
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
        // Defina o padrão de regex para o formato de hora "HH:mm:ss"
        val timePattern = "^([0-1]?[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]$".toRegex()

        // Verifique se a string inserida pelo usuário corresponde ao padrão de regex
        if (timePattern.matches(timeString)) {
            // A string está no formato correto, então você pode prosseguir com a conversão para LocalTime
            val formatterTime = DateTimeFormatter.ofPattern("HH:mm:ss")
            time = LocalTime.parse(timeString, formatterTime)
            // Restante do código...
        } else {
            // A string não está no formato correto, informe ao usuário ou trate o erro de acordo com suas necessidades
            // Por exemplo, exiba uma mensagem de erro no EditText ou mostre um Toast.
            edTime.error = "Formato de hora inválido. O formato deve ser HH:mm:ss (24 horas)."
            Log.i("TimeWod: ", "Unexpected wodTime format")
        }

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