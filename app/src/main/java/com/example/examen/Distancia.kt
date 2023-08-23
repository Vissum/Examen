package com.example.examen

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Distancia : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.distancia)

        val btnCalculate: Button = findViewById(R.id.btnCalculate)
        val editAmount: EditText = findViewById(R.id.editAmount)
        val editTime: EditText = findViewById(R.id.editTime)
        val textResult: TextView = findViewById(R.id.textResult)
        val btnBack: Button = findViewById(R.id.btnBack)

        btnCalculate.setOnClickListener {
            val amount = editAmount.text.toString().toDoubleOrNull()
            val time = editTime.text.toString().toDoubleOrNull()

            if (amount != null && time != null) {
                val distance = calculateDistance(amount, time)
                textResult.text = "La distancia es: $distance años luz"
            } else {
                textResult.text = "Ingresa valores válidos"
            }
        }

        btnBack.setOnClickListener {
            finish()
        }
    }

    private fun calculateDistance(amount: Double, time: Double): Double {
        return amount * 0.20 * time / 100
    }
}
