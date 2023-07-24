package com.example.yourwod.model

import java.text.DateFormat
import java.time.LocalDate
import java.time.LocalTime
import java.util.Date

data class Wod(
    val wodTitle: String,
    val wod: String,
    val wodTime: LocalTime,
    val wodDate: LocalDate
) {
}