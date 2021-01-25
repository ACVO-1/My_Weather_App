package ru.test.myweatherapp.activity.extensions

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.widget.LinearLayout
import android.widget.Toast
import ru.test.myweatherapp.R

fun Toast.toastColor ( color : Int){
    val toastContainer = this.view as LinearLayout
    toastContainer.setBackgroundColor(color)
    this.show()
}

