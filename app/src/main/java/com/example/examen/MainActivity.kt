package com.example.examen

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var estaAutenticado = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (!estaAutenticado) {
            mostrarDialogoInicioSesion()
        }

        findViewById<View>(R.id.btnUno).setOnClickListener {
            if (estaAutenticado) {
                val intent = Intent(this, Mate::class.java)
                startActivity(intent)
            } else {
                mostrarMensajeAutenticacionRequerida()
            }
        }
        findViewById<View>(R.id.btnastro).setOnClickListener {
            if (estaAutenticado) {
                val intent = Intent(this, Astro::class.java)
                startActivity(intent)
            } else {
                mostrarMensajeAutenticacionRequerida()
            }
        }



        findViewById<View>(R.id.btnCerrar).setOnClickListener {
            if (estaAutenticado) {
                finish()
            } else {
                mostrarMensajeAutenticacionRequerida()
            }
        }
    }

    private fun mostrarDialogoInicioSesion() {
        val vistaDialogo = layoutInflater.inflate(R.layout.dialog_login, null)
        val editTextUsuario = vistaDialogo.findViewById<EditText>(R.id.editTextUsername)
        val editTextContrasena = vistaDialogo.findViewById<EditText>(R.id.editTextPassword)

        val dialogo = AlertDialog.Builder(this)
            .setTitle("Ingrese sus Datos")
            .setView(vistaDialogo)
            .setPositiveButton("Entrar") { _, _ ->
                val usuario = editTextUsuario.text.toString()
                val contrasena = editTextContrasena.text.toString()



                if (esUsuarioValido(usuario, contrasena)) {
                    estaAutenticado = true
                } else {
                    mostrarMensajeAutenticacionFallida()
                }
            }
            .setOnCancelListener {
                finish()
            }
            .setCancelable(false)
            .show()
    }

    private fun esUsuarioValido(usuario: String, contrasena: String): Boolean {


        return usuario == "Exa" && contrasena == "men"
    }

    private fun mostrarMensajeAutenticacionRequerida() {
        AlertDialog.Builder(this)
            .setTitle("Autenticación Requerida")
            .setMessage("Por favor inicia  para acceder a los controles.")
            .setPositiveButton("OK", null)
            .show()
    }

    private fun mostrarMensajeAutenticacionFallida() {
        AlertDialog.Builder(this)
            .setTitle("Autenticación Fallida")
            .setMessage("Usuario o contraseña incorrectos. Por favor intenta nuevamente.")
            .setPositiveButton("OK", null)
            .show()
    }
}

