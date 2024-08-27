package com.comunidadedevspace.imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val calcButton = findViewById<Button>(R.id.button)

        calcButton.setOnClickListener {
            val weightStr: String = edtWeight.text.toString()
            val heightStr: String = edtHeight.text.toString()

            if(weightStr == "" || heightStr == "") {
                Snackbar
                    .make(
                    edtWeight,
                    "All fields must be filled",
                    Snackbar.LENGTH_LONG
                ).show()


            } else {
                val weight = weightStr.toFloat()
                val height = heightStr.toFloat()
                val heightq2 = height * height
                val result = weight / heightq2


                val intent = Intent(this, ResultActivity::class.java)
                intent.putExtra(KEY_RESULT_IMC, result)
                startActivity(intent)
            }




        }
    }
}