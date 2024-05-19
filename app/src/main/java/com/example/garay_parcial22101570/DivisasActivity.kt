package com.example.garay_parcial22101570

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class DivisasActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_divisas)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val etTipo: TextView = findViewById(R.id.etTipo)
        val etMonto: TextView = findViewById(R.id.etMonto)
        val btnCalcular: Button = findViewById(R.id.btnCalcular)
        val etResultado= findViewById<TextView>(R.id.txtResultado)
        val txtBilletegrande= findViewById<TextView>(R.id.txtBilletegrande)
        val txtBilletemediano= findViewById<TextView>(R.id.txtBilletemediano)
        val txtBilletechico= findViewById<TextView>(R.id.txtBilletechico)

        btnCalcular.setOnClickListener{
            var Soles = etTipo.text.toString().toDouble() * etMonto.text.toString().toDouble()
            etResultado.text = Soles.toString()
            var result = billetestotales(Soles)
            for ((billete, cantidad) in result){
                if (billete== 100){
                    txtBilletegrande.text = cantidad.toString() + " Billetes de  " + billete.toString()
                }else if(billete == 50){
                    txtBilletemediano.text = cantidad.toString() + " Billetes de  " + billete.toString()
                }else if(billete == 20){
                    txtBilletechico.text = cantidad.toString() + " Billetes de  " + billete.toString()
                }
            }
        }

    }
    fun billetestotales(monto: Double): Map<Int, Int>{
        val billetes = listOf(100,50,20)
        val resul = mutableMapOf<Int, Int>()

        var montoRestante = monto.toInt()

        for(billete in billetes){
            val cantidadBilletes = montoRestante / billete
            if (cantidadBilletes > 0){
                resul[billete] = cantidadBilletes
                montoRestante %= billete
            }
        }
        return resul
    }
}