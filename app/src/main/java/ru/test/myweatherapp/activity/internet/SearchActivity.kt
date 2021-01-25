package ru.test.myweatherapp.activity.internet

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_search.*
import ru.test.myweatherapp.R
import ru.test.myweatherapp.activity.extensions.toastColor

class SearchActivity : AppCompatActivity() {

    private lateinit var mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        mp = MediaPlayer.create(this, R.raw.btn_snd)
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }

    fun onSearchClick(view: View) {
        mp.start()

        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception)  {
        }

        if (text_search.text.isNullOrEmpty()){
           val toast = Toast.makeText(this,"Enter city name",Toast.LENGTH_SHORT)
            toast.toastColor(getColor(android.R.color.holo_red_light))
            return
        }
        intent.putExtra("search", text_search.text.toString())
        intent = Intent(this,SearchResultActivity::class.java)
        startActivity(intent)
    }
}
