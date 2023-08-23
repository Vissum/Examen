package com.example.examen

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class interes : AppCompatActivity() {

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.interes)

        val spinnerTiempo: Spinner = findViewById(R.id.spinnerTiempo)
        val tiempoOptions = resources.getStringArray(R.array.tiempo_array)
        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, tiempoOptions)
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerTiempo.adapter = spinnerAdapter

        findViewById<View>(R.id.btnCalcular).setOnClickListener {
            val editTextCantidad = findViewById<EditText>(R.id.editCantidad)
            val editTextTasa = findViewById<EditText>(R.id.editTasa)
            val textViewResultado = findViewById<TextView>(R.id.textResultado)
            val tiempoUnit = spinnerTiempo.selectedItem.toString()

            val cantidad = editTextCantidad.text.toString().toDoubleOrNull()
            val tasa = editTextTasa.text.toString().toDoubleOrNull()

            if (cantidad != null && tasa != null) {
                val tiempoEnMeses = convertirTiempoAMeses(cantidad, tiempoUnit)
                val interes = calcularInteres(cantidad, tasa, tiempoEnMeses)
                textViewResultado.text = "El interés es: $interes"
            } else {
                textViewResultado.text = "Ingresa valores válidos"
            }
        }

        findViewById<View>(R.id.btnVolver).setOnClickListener {
            finish()
        }
    }

    private fun convertirTiempoAMeses(cantidad: Double, unidad: String): Int {
        return when (unidad) {
            "Años" -> (cantidad * 12).toInt()
            "Meses" -> cantidad.toInt()
            "Días" -> (cantidad / 30).toInt() // Asumiendo un promedio de 30 días por mes
            else -> 0
        }
    }

    private fun calcularInteres(cantidad: Double, tasa: Double, tiempoEnMeses: Int): Double {
        return cantidad * tasa * tiempoEnMeses / 100
    }
}
