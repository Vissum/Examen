package com.example.examen

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import kotlin.math.pow

class interesCom : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interescom)

        val spinnerTiempoCom: Spinner = findViewById(R.id.spinnerTiempoCom)
        val tiempoOptions = resources.getStringArray(R.array.tiempo_array)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiempoOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTiempoCom.adapter = spinnerAdapter

        findViewById<View>(R.id.btnCalcularCom).setOnClickListener {
            val editTextCantidadCom = findViewById<EditText>(R.id.editCantidadCom)
            val editTextTasaCom = findViewById<EditText>(R.id.editTasaCom)
            val editTextTiempoCom = findViewById<EditText>(R.id.editTiempoCom)
            val textViewResultadoCom = findViewById<TextView>(R.id.textResultadoCom)
            val tiempoUnitCom = spinnerTiempoCom.selectedItem.toString()

            val cantidadCom = editTextCantidadCom.text.toString().toDoubleOrNull()
            val tasaCom = editTextTasaCom.text.toString().toDoubleOrNull()
            val tiempoCom = editTextTiempoCom.text.toString().toDoubleOrNull()

            if (cantidadCom != null && tasaCom != null && tiempoCom != null) {
                val resultado = calcularInteresCompuesto(cantidadCom, tasaCom, tiempoCom, tiempoUnitCom)
                val resultadoFormateado = String.format("%.2f", resultado)
                textViewResultadoCom.text = "El monto total es: $resultadoFormateado"
            } else {
                textViewResultadoCom.text = "Ingresa valores válidos"
            }
        }

        findViewById<View>(R.id.btnVolverCom).setOnClickListener {
            finish()
        }

    }

    private fun calcularInteresCompuesto(cantidad: Double, tasa: Double, tiempo: Double, unidad: String): Double {
        val tiempoEnMeses = convertirTiempoAMeses(tiempo, unidad)
        val tasaDecimal = tasa / 100.0
        return cantidad * (1 + tasaDecimal).pow(tiempoEnMeses)
    }

    private fun convertirTiempoAMeses(cantidad: Double, unidad: String): Int {
        return when (unidad) {
            "Años" -> (cantidad * 12).toInt()
            "Meses" -> cantidad.toInt()
            "Días" -> (cantidad / 30).toInt()
            else -> 0
        }
    }
}
