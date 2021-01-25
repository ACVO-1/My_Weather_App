package ru.test.myweatherapp

import khttp.responses.Response
import org.json.JSONObject
import org.junit.Test
import ru.test.myweatherapp.activity.extensions.formatDate
import ru.test.myweatherapp.activity.extensions.formatTimeDay
import ru.test.myweatherapp.activity.internet.LANG
import ru.test.myweatherapp.activity.internet.jsonGetRequest
import java.util.*


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        val response: Response =
            khttp.get("http://api.openweathermap.org/data/2.5/weather?q=omsk&lang=$LANG&units=metric&appid=2432de4ce093d9479f611edbe48a5760")
        val obj = response.jsonObject





        if (obj["cod"] == "404") {
            println("Ошибка города")

        } else {
            //city name
            //obj["name"]
            //base date
            //obj["dt"]
            //base weather split
            //obj["main"].toString().split(",")
            //temp
            //obj["main"].toString().split(",")[0].split(":")[1]
            //clouds
            //obj.getJSONArray("weather")[0].toString().split(",")[2].split(":")[1].replace('"',' ').trim()
            //humidity
            //obj["main"].toString().split(",")[2].split(":")[1]
            //date base
            val date = Date(obj.getLong("dt") * 1000)
            //date format
            //date.formatWeek()
            //date.formatDay()


            print(
                """
            ${obj["name"]}
            ${obj["dt"]}
            ${obj["main"].toString().split(",")[0].split(":")[1]}
            ${
                    obj.getJSONArray("weather")[0].toString().split(",")[2].split(":")[1].replace(
                        '"',
                        ' '
                    ).trim()
                }
            ${obj["main"].toString().split(",")[2].split(":")[1]}
            ${date.formatDate()}
            ${date.formatTimeDay()}
        """.trimIndent()
            )
        }
    }
    @Test
    fun test(){
        val string= jsonGetRequest("http://api.openweathermap.org/data/2.5/weather?q=omsk&lang=$LANG&units=metric&appid=2432de4ce093d9479f611edbe48a5760")
      val obj = JSONObject(string!!)
        val date = Date(obj.getLong("dt") * 1000)
        print(
            """
            ${obj["name"]}
            ${obj["dt"]}
            ${obj["main"].toString().split(",")[0].split(":")[1]}
            ${
                obj.getJSONArray("weather")[0].toString().split(",")[2].split(":")[1].replace(
                    '"',
                    ' '
                ).trim()
            }
            ${obj["main"].toString().split(",")[2].split(":")[1]}
            ${date.formatDate()}
            ${date.formatTimeDay()}
        """.trimIndent()
        )
    }

}

