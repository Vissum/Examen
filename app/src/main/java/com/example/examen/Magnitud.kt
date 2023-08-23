package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.log10

class Magnitud : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.magnitud)

        val editFlujo: EditText = findViewById(R.id.editFlujo)
        val editDistancia: EditText = findViewById(R.id.editDistancia)
        val btnCalcular: Button = findViewById(R.id.btnCalcularMag)
        val textResultado: TextView = findViewById(R.id.textResultadoMag)
        val btnVolver: Button = findViewById(R.id.btnVolverMag)

        btnCalcular.setOnClickListener {
            val flujo = editFlujo.text.toString().toDouble()
            val distancia = editDistancia.text.toString().toDouble()
            val magnitud = calcularMagnitud(flujo, distancia)
            textResultado.text = getString(R.string.magnitud_resultado, magnitud)
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun calcularMagnitud(flujo: Double, distancia: Double): Double {
        return -2.5 * log10(flujo) + 5 * log10(distancia / 10.0)
    }
}
