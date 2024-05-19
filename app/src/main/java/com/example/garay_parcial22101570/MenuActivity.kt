package com.example.garay_parcial22101570

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_menu)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val btnTkambio: Button = findViewById(R.id.btnTkambio)
        val btnEdad: Button = findViewById(R.id.btnEdad)

        btnTkambio.setOnClickListener {
            val intent = Intent(this, DivisasActivity::class.java)
            startActivity(intent)
        }
        btnEdad.setOnClickListener {
            val intent = Intent(this, EdadActivity::class.java)
            startActivity(intent)
        }
    }
}