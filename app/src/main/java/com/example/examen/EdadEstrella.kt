package com.example.examen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class EdadEstrella : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.edad_estrella)

        val editAniosLuz: EditText = findViewById(R.id.editAniosLuz)
        val btnCalcular: Button = findViewById(R.id.btnCalcularEdad)
        val textResultado: TextView = findViewById(R.id.textResultadoEdad)
        val btnVolver: Button = findViewById(R.id.btnVolverEdad)

        btnCalcular.setOnClickListener {
            val distanciaAniosLuz = editAniosLuz.text.toString().toDouble()
            val edadEstrella = calcularEdadEstrella(distanciaAniosLuz)
            textResultado.text = getString(R.string.edad_resultado, edadEstrella)
        }

        btnVolver.setOnClickListener {
            finish()
        }
    }

    private fun calcularEdadEstrella(distanciaAniosLuz: Double): Double {

        return distanciaAniosLuz * 1000
    }
}
