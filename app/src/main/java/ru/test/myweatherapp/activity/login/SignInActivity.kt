package ru.test.myweatherapp.activity.login

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_sign_in.*
import ru.test.myweatherapp.R
import ru.test.myweatherapp.activity.MainActivity
import ru.test.myweatherapp.activity.extensions.toastColor


class SignInActivity : AppCompatActivity() {

    lateinit var mp: MediaPlayer
    private var a: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
         a = intent.getStringExtra("user")
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        mp = MediaPlayer.create(this, R.raw.btn_snd)
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }

    fun onSignInClick(view: View) {
        val loginText = text_login_reg.text.toString().trim()
        val passText = text_password_reg.text.toString().trim()
        val list = a?.split("-")
        val login: String

        mp.start()
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
        }

        when (view.id) {
            R.id.button_si -> if (loginText.isNotEmpty() && passText.isNotEmpty()) {
                if (list != null) {

                    for (id in list.indices) {

                        if (list[id].split(",").get(0) == "($loginText" &&
                            list[id].split(",").get(1).trim() != "$passText)"
                        ) {
                            text_password_reg.text.clear()
                            val toast = Toast.makeText(
                                this,
                                getString(R.string.password_error),
                                Toast.LENGTH_SHORT
                            )
                            toast.toastColor(getColor(android.R.color.holo_red_light))
                            return
                        }
                        if (list[id] == ((loginText to passText).toString())) {
                            val toast = Toast.makeText(
                                this,
                                getString(R.string.user_success),
                                Toast.LENGTH_SHORT
                            )
                            toast.toastColor(getColor(android.R.color.holo_blue_dark))
                            intent = Intent(this, MainActivity::class.java)
                            login = list[id].split(",").get(0).trim().substring(1)
                            intent.putExtra("login", login)
                            startActivity(intent)

                            break
                        } else {
                            val toast = Toast.makeText(
                                this,
                                getString(R.string.user_not_found),
                                Toast.LENGTH_SHORT
                            )
                            toast.toastColor(getColor(android.R.color.holo_red_light))
                            text_password_reg.text.clear()
                            return
                        }
                    }
                }
            } else {
                val toast = Toast.makeText(
                    this,
                    getString(R.string.enter_login_or_password),
                    Toast.LENGTH_SHORT
                )
                toast.toastColor(getColor(android.R.color.holo_red_light))
                text_password_reg.text.clear()
                return
            }
            R.id.button_r -> {
                intent = Intent(this, RegisteredActivity::class.java)
                startActivity(intent)
            }
        }
    }
}