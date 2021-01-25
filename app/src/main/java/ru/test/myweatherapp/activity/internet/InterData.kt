package ru.test.myweatherapp.activity.internet

import android.content.Intent
import android.net.Uri
import java.util.*

const val API_KEY = "2432de4ce093d9479f611edbe48a5760"
val LANG = Locale.getDefault().language
var CITY_NAME : String? = null
val URL = "api.openweathermap.org/data/2.5/weather?q=$CITY_NAME&lang=$LANG&units=metric&appid=$API_KEY"

