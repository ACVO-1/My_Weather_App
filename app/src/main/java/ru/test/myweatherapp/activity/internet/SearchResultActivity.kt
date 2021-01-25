package ru.test.myweatherapp.activity.internet

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.json.JSONObject
import ru.test.myweatherapp.R


class SearchResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search_result)
       // CITY_NAME = intent.getStringExtra("search")?.trim()
      // val string = jsonGetRequest("http://api.openweathermap.org/data/2.5/weather?q=Omsk&lang=ru&units=metric&appid=2432de4ce093d9479f611edbe48a5760")
       // Toast.makeText(this,string,Toast.LENGTH_SHORT).show()

        // val obj = JSONObject(string!!)
//
       //val date = Date(obj.getLong("dt") * 1000)
//
       //if (obj["cod"] == "404") {
       //    val toast = Toast.makeText(this, "Wrong city name", Toast.LENGTH_SHORT)
       //    toast.toastColor(getColor(android.R.color.holo_red_light))
       //    Thread.sleep(2000)
       //    intent = Intent(this, SearchActivity::class.java)
       //    text_view_city_name.text = "ERROR"
       //} else {
       //    text_view_time_result.text = date.formatTimeDay()
       //     text_view_date_result.text = date.formatDate()
       //     text_view_temp_result.text = obj["main"].toString().split(",")[0].split(":")[1]
       //     text_view_clouds_result.text = obj.getJSONArray("weather")[0].toString().split(",")[2].split(":")[1].replace('"',' ').trim()
       //     text_view_humidity_result.text = obj["main"].toString().split(",")[2].split(":")[1]
       // }
    }


}
