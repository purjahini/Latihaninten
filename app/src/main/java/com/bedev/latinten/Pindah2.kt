package com.bedev.latinten

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_pindah2.*
import org.jetbrains.anko.startActivityForResult

class Pindah2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pindah2)

        val nama=intent.getStringExtra("Username")
        ///val password=intent.getIntExtra("password",0)
        val email = intent.getStringExtra("email")
      //  TvMoveData.setText("User Name ="+ nama + ",\nPassword ="+password)
        Email.setText(email)
       // Password.setText(password)
        Username.setText(nama)

        button_Impli.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            startActivityForResult(intent, 0)
        }


    }
    var selectUrlFoto: Uri? = null

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 0 && resultCode == Activity.RESULT_OK && data != null){

            selectUrlFoto = data.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, selectUrlFoto)
            imageView.setImageBitmap(bitmap)
        }
    }
}
