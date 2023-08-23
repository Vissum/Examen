package com.example.examen

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.DecimalFormat

class Depreciacion : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.depreciacion)

        val btnCalcularDepDesc = findViewById<Button>(R.id.btnCalcularDepDesc)
        val btnVolverDepDesc = findViewById<Button>(R.id.btnVolverDepDesc)
        val editCantidadDepDesc = findViewById<EditText>(R.id.editCantidadDepDesc)
        val editTiempoDepDesc = findViewById<EditText>(R.id.editTiempoDepDesc)
        val textResultadoDepDesc = findViewById<TextView>(R.id.textResultadoDepDesc)

        btnCalcularDepDesc.setOnClickListener {
            val cantidad = editCantidadDepDesc.text.toString().toDoubleOrNull()
            val tiempo = editTiempoDepDesc.text.toString().toIntOrNull()

            if (cantidad != null && tiempo != null) {
                val resultado = calcularDepreciacionDescuento(cantidad, tiempo)
                val formattedResultado = DecimalFormat("#.##").format(resultado)
                textResultadoDepDesc.text = "Resultado: $formattedResultado"
            } else {
                textResultadoDepDesc.text = "Ingrese valores válidos"
            }
        }

        btnVolverDepDesc.setOnClickListener {
            finish()
        }
    }

    private fun calcularDepreciacionDescuento(cantidad: Double, tiempo: Int): Double {
        return cantidad * 0.20 * tiempo / 100
    }
}
