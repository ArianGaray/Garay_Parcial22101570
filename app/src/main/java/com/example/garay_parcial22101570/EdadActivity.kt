package com.example.garay_parcial22101570

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.SimpleDateFormat
import java.util.Date
import kotlin.math.abs

class EdadActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_edad)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etFechaNac: TextView = findViewById(R.id.etFechaNac)
        val etResultadoedad= findViewById<TextView>(R.id.txtResulEdad)
        val btnCalcularedad: Button = findViewById(R.id.btnCalcularEdad)

        btnCalcularedad.setOnClickListener{
            var resultadoEdad = CalcularEdadDias(etFechaNac.text.toString())
            etResultadoedad.text = resultadoEdad.toString()
        }


    }
    fun CalcularEdadDias(fechaDeInicio:String):Int{
        val dateFormat = SimpleDateFormat("dd-MM-yyyy")
        val stHoy = dateFormat.format(Date())



        val date2: Date = dateFormat.parse(stHoy) ?: Date()
        val date3: Date = dateFormat.parse(fechaDeInicio) ?: Date()

        val difLong = abs(date3.time - date2.time)

        val segundos = (difLong / 1000).toString()
        val diaDif = (difLong / (24*60*60*1000)).toInt()
        return diaDif
    }
}