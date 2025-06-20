package com.example.imc_formule

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextWeight: EditText = findViewById(R.id.editTextWeight)
        val editTextSize: EditText = findViewById(R.id.editTextSize)
        val calculateIMCButton: Button = findViewById(R.id.calculateIMCButton)
        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val resultTextViewComment: TextView = findViewById(R.id.resultTextViewComment)

        val imageView = findViewById<ImageView>(R.id.imcResultImage)

        calculateIMCButton.setOnClickListener { view ->
            val weight = editTextWeight.text.toString().toDouble()
            var size = editTextSize.text.toString().toDouble()
            val result = weight / (size*size);
            size = size / 100;
            println("weight: "+weight)
            println("size: "+size)
            println("size*size: "+size*size)
            println("imc: "+result)
            println("weight / size*size: "+(weight / (size*size)))
            println("weight / size*size: "+(67 / 124))
            textViewResult.text = result.toString()
            if(result < 18.5){
                imageView.setImageResource(R.drawable.maigre)
                resultTextViewComment.text = "Maigre";
            }
            else if(result >= 18.5 && result < 25){
                imageView.setImageResource(R.drawable.normal)
                resultTextViewComment.text = "Normal";
            }
            else if(result >= 25 && result < 30){
                imageView.setImageResource(R.drawable.surpoids)
                resultTextViewComment.text = "Surpoids";
            }
            else if(result >= 30 && result < 40){
                imageView.setImageResource(R.drawable.obese)
                resultTextViewComment.text = "Obésité modérée";
            }
            else if(result >= 40){
                imageView.setImageResource(R.drawable.t_obese)
                resultTextViewComment.text = "Obésité sévère";
            }

        }

    }
}