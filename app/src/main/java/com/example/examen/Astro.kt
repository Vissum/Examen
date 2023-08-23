package com.example.examen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class Astro : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.astro)


        findViewById<View>(R.id.btnCerrar).setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.btnDist).setOnClickListener {
            val intent = Intent(this, Distancia::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.btnMag).setOnClickListener {
            val intent = Intent(this, Magnitud::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btnEd).setOnClickListener {
            val intent = Intent(this, EdadEstrella::class.java)
            startActivity(intent)
        }


    }
}
