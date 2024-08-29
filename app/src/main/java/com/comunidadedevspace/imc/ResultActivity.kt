package com.comunidadedevspace.imc

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text

const val KEY_RESULT_IMC = "ResultActivity.KEY_RESULT_IMC"
const val KEY_WEIGHT_IMC = "ResultActivity.KEY_WEIGHT_IMC"
const val KEY_HEIGHT_IMC = "ResultActivity.KEY_HEIGHT_IMC"

class ResultActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_result)

        val result = intent.getFloatExtra(KEY_RESULT_IMC, 0F)
        val height = intent.getFloatExtra(KEY_HEIGHT_IMC,0F)
        val weight = intent.getFloatExtra(KEY_WEIGHT_IMC,0F)


        val tvResult = findViewById<TextView>(R.id.tv_result)
        val tvClassification = findViewById<TextView>(R.id.tv_classification)

        val tvWeightAndHeight = findViewById<TextView>(R.id.tv_WeightAndHeight)


        tvResult.text = result.toString()

        tvWeightAndHeight.text = "Your weight: $weight Your height: $height"


        val classification: String = if(result <= 18.5f){
            "UNDERWEIGHT"
        } else if(result > 18.5f && result < 25f){
            "HEALTHY WEIGHT"
        } else if(result >= 25f && result <= 29.9f){
            "OVERWEIGHT"
        } else if(result >= 30f && result <= 39.9f){
            "OBESE"
        } else{
            "SEVERELY OBESE"
        }

        tvClassification.text = classification

        when (classification) {
            "UNDERWEIGHT" -> tvClassification.setTextColor(Color.parseColor("#f16549"))
            "HEALTHY WEIGHT" -> tvClassification.setTextColor(Color.parseColor("#6bab31"))
            "OVERWEIGHT" -> tvClassification.setTextColor(Color.parseColor("#f16549"))
            "OBESE" -> tvClassification.setTextColor(Color.parseColor("#eb4930"))
            "SEVERELY OBESE" -> tvClassification.setTextColor(Color.parseColor("#ff2200"))
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets


        }
    }
}