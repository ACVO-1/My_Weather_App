package ru.test.myweatherapp.activity.extensions

import ru.test.myweatherapp.activity.internet.LANG
import java.text.SimpleDateFormat
import java.util.*

const val SECONDS = 1000L
const val MINUTE = 60 * SECONDS
const val HOUR = 60 * MINUTE
const val DAY = 24 * HOUR

fun Date.format(pattern: String = "HH:mm:ss dd.MM.yy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale(LANG))
    return dateFormat.format(this)
}

fun Date.formatDate(pattern: String = "dd.MMMM.yyyy"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale(LANG))
    return dateFormat.format(this)
}

fun Date.formatTimeDay(pattern: String = "HH:mm EEEE"): String {
    val dateFormat = SimpleDateFormat(pattern, Locale(LANG))
    return dateFormat.format(this)
}