package ru.test.myweatherapp.activity.login

import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_registered.*
import ru.test.myweatherapp.R
import ru.test.myweatherapp.activity.extensions.toastColor
import com.google.android.material.snackbar.Snackbar


class RegisteredActivity : AppCompatActivity() {


    lateinit var mUser: SharedPreferences
    var builder: StringBuilder? = null
    lateinit var mp: MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registered)

        mUser = getSharedPreferences("users", MODE_PRIVATE)
        builder = mUser.getString("users", "")?.let { StringBuilder(it) }
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
        mp = MediaPlayer.create(this, R.raw.btn_snd)
    }

    override fun onDestroy() {
        super.onDestroy()
        mp.release()
    }

    fun onRegisterClick(view: View) {
        val textLogin = text_login_reg.text.toString().trim()
        val textName = text_name_reg.text.toString().trim()
        val textPass1 = text_password_reg1.text.toString().trim()
        val textPass2 = text_password_reg2.text.toString().trim()
        val list = builder?.split("-")

        Snackbar.make(view,"asd",Snackbar.LENGTH_LONG)

        mp.start()
        try {
            val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
        }

        if (textLogin.isNotEmpty() && textName.isNotEmpty() && textPass1.isNotEmpty() && textPass2.isNotEmpty()) {

            if (textPass1 == textPass2) {
                if (list != null) {
                    for (id in list.indices) {
                        if (list[id] == ((textLogin to textPass1).toString()) || list[id].split(",")
                                .get(
                                    0
                                ) == "($textLogin"
                        ) {
                            val toast = Toast.makeText(
                                this,
                                getString(R.string.user_exist),
                                Toast.LENGTH_SHORT
                            )
                            toast.toastColor(getColor(android.R.color.holo_red_light))

                            text_login_reg.text.clear()
                            text_name_reg.text.clear()
                            text_password_reg1.text.clear()
                            text_password_reg2.text.clear()
                            return
                        }
                    }
                    intent = Intent(this, SignInActivity::class.java)
                    builder?.append(textLogin to textPass1)?.append("-")
                    val editor = mUser.edit()
                    editor.putString("users", builder.toString()).apply()
                    intent.putExtra("user", mUser.getString("users", ""))
                    val toast = Toast.makeText(
                        this,
                        getString(R.string.user_success),
                        Toast.LENGTH_SHORT
                    )
                    toast.toastColor(getColor(android.R.color.holo_blue_dark))
                    startActivity(intent)
                }
            } else {
                val toast = Toast.makeText(
                    this,
                    getString(R.string.passwords_not_equals),
                    Toast.LENGTH_SHORT
                )
                toast.toastColor(getColor(android.R.color.holo_red_light))
                text_password_reg1.text.clear()
                text_password_reg2.text.clear()
            }
        } else {
            val toast =
                Toast.makeText(this, getString(R.string.fill_all_fields), Toast.LENGTH_SHORT)
            toast.toastColor(getColor(android.R.color.holo_red_light))
            text_password_reg1.text.clear()
            text_password_reg2.text.clear()
        }
    }

    fun onSignInClick(view: View) {
        mp.start()
        intent = Intent(this, SignInActivity::class.java)
        intent.putExtra("user", mUser.getString("users", ""))
        startActivity(intent)
    }
}