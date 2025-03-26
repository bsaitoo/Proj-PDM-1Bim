package com.example.projetopdm1bim

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val lblCalculo = findViewById<TextView>(R.id.lblCalculo)
        val edtPeso = findViewById<EditText>(R.id.edtPeso)
        val edtAltura = findViewById<EditText>(R.id.edtAltura)
        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        val btnLimpar = findViewById<Button>(R.id.btnLimpar)

        btnLimpar.setOnClickListener {

        }

        btnCalcular.setOnClickListener {
            val peso = edtPeso.text.toString().toDoubleOrNull()
            val altura = edtAltura.text.toString().toDoubleOrNull()

            if (peso != null && altura != null) {
                var imc: Double? = peso / (altura * altura)
                val imcFormatado = String.format("%.2f", imc)
                if ((imc ?: 0.0) <= 18.5) {
                    lblCalculo.text = "IMC: " + imcFormatado + "\nClassificação: Abaixo do Peso"
                } else if (((imc ?: 0.0) >= 18.50) && ((imc ?: 0.0) <= 24.9)) {
                    lblCalculo.text = "IMC: " + imcFormatado + "\nClassificação: Peso Normal"
                } else if (((imc ?: 0.0) >= 25) && ((imc ?: 0.0) <= 29.9)) {
                    lblCalculo.text = "IMC: " + imcFormatado + "\nClassificação: Sobrepeso"
                } else if (((imc ?: 0.0) >= 30) && ((imc ?: 0.0) <= 34.9)) {
                    lblCalculo.text = "IMC: " + imcFormatado + "\nClassificação: Obesidade I"
                } else if (((imc ?: 0.0) >= 35) && ((imc ?: 0.0) <= 39.9)) {
                    lblCalculo.text = "IMC: " + imcFormatado + "\nClassificação: Obesidade II"
                } else if ((imc ?: 0.0) >= 40) {
                    lblCalculo.text = "IMC: " + imcFormatado + "\nClassificação: Obesidade III"
                } else {
                    lblCalculo.text = "Coloque valores válidos!"
                }
            }
        }
    }
}