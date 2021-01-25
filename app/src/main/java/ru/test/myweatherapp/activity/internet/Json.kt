package ru.test.myweatherapp.activity.internet

import java.io.IOException
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL
import java.util.*

fun jsonGetRequest(urlQueryString: String?): String? {
    var json: String? = null
    try {
        val url = URL(urlQueryString)
        val connection = url.openConnection() as HttpURLConnection
        connection.doOutput = true
        connection.instanceFollowRedirects = false
        connection.requestMethod = "GET"
        connection.setRequestProperty("Content-Type", "application/json")
        connection.setRequestProperty("charset", "utf-8")
        connection.connect()
        val inStream: InputStream = connection.inputStream
        json = streamToString(inStream) // input stream to string
    } catch (ex: IOException) {
        ex.printStackTrace()
    }
    return json
}
private fun streamToString(inputStream: InputStream): String? {
    return Scanner(inputStream, "UTF-8").useDelimiter("\\Z").next()
}