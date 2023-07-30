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
import com.example.yourwod.databinding.FormAddWodBinding
import com.example.yourwod.model.Wod
import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class FormAddWod : AppCompatActivity() {

    private val binding by lazy { FormAddWodBinding.inflate(layoutInflater) }
    private var time: LocalTime = LocalTime.now()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        btnBack()
        btnSave()
        setContentView(binding.root)
    }


    private fun btnBack() {
        val btnBack = binding.btnFormWodBack
        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun btnSave() {
        val btnSave = binding.btnFormWodSaveWod
        val dao = DaoWod()
        btnSave.setOnClickListener {
            val newWod = createWod()
            dao.addWod(newWod)
            finish()
        }
    }

    private fun createWod(): Wod {

        val title = binding.etFormWodTitleWod.text.toString()
        val workout = binding.etFormWodWod.text.toString()
        val timeString = binding.etFormWodTimeWod.text.toString()
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
            binding.etFormWodTimeWod.error = "Formato de hora inválido. O formato deve ser HH:mm:ss (24 horas)."
            Log.i("TimeWod: ", "Unexpected wodTime format")
        }

        val dateString = binding.etFormWodDateWod.text.toString()
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