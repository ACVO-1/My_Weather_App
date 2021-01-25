package ru.test.myweatherapp.activity.internet

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import ru.test.myweatherapp.R

class ListOfCityActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_of_city)
        khttp.get(URL)
    }
}
