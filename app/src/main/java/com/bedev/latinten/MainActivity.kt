package com.bedev.latinten

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.intentFor

class MainActivity : AppCompatActivity(), AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button_register.setOnClickListener {
            daftar()
//            startActivity(intentFor<Pindah2>()
//                .putExtra("Username","Bedjo Banget")
//                .putExtra("password",1234567890)
//                )


        }
    }

    private fun daftar() {
        val email = email_edittext_register.text.toString()
        val username = username_edittext_register.text.toString()
        val password = password_edittext_register.text.toString()

        if (email.isEmpty() || password.isEmpty() || username.isEmpty()) {

            email_edittext_register.error = "Email Harus di isi"
            password_edittext_register.error = "Password harus di isi"
            username_edittext_register.error = "Username Harus di isi"
            return
        }

        startActivity(
            intentFor<Pindah2>()
                .putExtra("Username", username)
                .putExtra("email", email)
        )


    }
}
