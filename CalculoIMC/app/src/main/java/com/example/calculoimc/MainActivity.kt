package com.example.calculoimc

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.calculoimc.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.calcularButton.setOnClickListener {
            val peso = binding.pesoEdit.text.toString().toDoubleOrNull()
            val altura = binding.alturaEdit.text.toString().toDoubleOrNull()

            if (peso != null && altura != null) {

                val imc = calcularIMC(peso, altura)
                val descricao = descricaoIMC(imc)


                val intent = Intent(this, OutraTelaActivity::class.java)
                intent.putExtra("IMC", imc)
                intent.putExtra("descricaoIMC", descricao)
                startActivity(intent)
            } else {

                binding.resultaodIMC.text = "Erro! Por favor, insira valores válidos."
            }
        }
    }


    private fun calcularIMC(peso: Double, altura: Double): Double {
        return peso / (altura * altura)
    }


    private fun descricaoIMC(imc: Double): String {
        return when {
            imc < 18.5 -> "Abaixo do peso"
            imc < 24.9 -> "Peso normal"
            imc < 29.9 -> "Sobrepeso"
            imc < 34.9 -> "Obesidade grau I"
            imc < 39.9 -> "Obesidade grau II"
            else -> "Obesidade grau III"
        }
    }
}
