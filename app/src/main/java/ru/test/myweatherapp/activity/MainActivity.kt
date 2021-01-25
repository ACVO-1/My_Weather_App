package ru.test.myweatherapp.activity

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import ru.test.myweatherapp.R
import ru.test.myweatherapp.activity.internet.SearchActivity


class MainActivity : AppCompatActivity() {

    lateinit var  mp : MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val name = intent.getStringExtra("login")
        text_login_name.text = getString(R.string.welcome_name)+name
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        mp = MediaPlayer.create(this,R.raw.btn_snd)
    }

    override fun onResume() {
        super.onResume()
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }

    fun onMenuButtonClick(view: View) {
        mp.start()
        when (view.id) {
            // R.id.list_button -> intent = Intent(this,ListOfCityActivity::class.java)
             R.id.map_button -> intent = Intent(this, MapsActivity::class.java)
             R.id.search_button -> intent = Intent(this, SearchActivity::class.java)
        }

        startActivity(intent)
    }
}