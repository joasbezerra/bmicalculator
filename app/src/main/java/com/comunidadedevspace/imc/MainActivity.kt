package com.comunidadedevspace.imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val edtHeight = findViewById<TextInputEditText>(R.id.edt_height)
        val edtWeight = findViewById<TextInputEditText>(R.id.edt_weight)
        val calcButton = findViewById<Button>(R.id.button)

        calcButton.setOnClickListener {
            val weight = edtWeight.text
            val height = edtHeight.text
            val result =
        }
    }
}