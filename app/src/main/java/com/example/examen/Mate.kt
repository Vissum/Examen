package com.example.examen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View

class Mate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.mate)

        findViewById<View>(R.id.btnCerrar).setOnClickListener {
            finish()
        }

        findViewById<View>(R.id.btnInt).setOnClickListener {
            val intent = Intent(this, interes::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btnIntC).setOnClickListener {
            val intent = Intent(this, interesCom::class.java)
            startActivity(intent)
        }
        findViewById<View>(R.id.btnDep).setOnClickListener {
            val intent = Intent(this, Depreciacion::class.java)
            startActivity(intent)
        }



    }
}
