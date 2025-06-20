package com.example.imc_formule

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextAmount: EditText = findViewById(R.id.editTextAmount)
        val btnCompute: Button = findViewById(R.id.btnCompute)
        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val listViewResult: ListView = findViewById(R.id.listViewResults)
        val data: MutableList<String> = ArrayList()
        val stringArrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, data)

        listViewResult.adapter = stringArrayAdapter

        btnCompute.setOnClickListener { view ->
            val amount = editTextAmount.text.toString().toDouble()
            val result = amount * 11
            textViewResult.text = result.toString()
            data.add("$amount => $result")
            stringArrayAdapter.notifyDataSetChanged()
            editTextAmount.setText("")
        }

    }
}