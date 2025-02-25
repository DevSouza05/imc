package com.example.calculoimc

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class OutraTelaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_outra_tela)


        val imc = intent.getDoubleExtra("IMC", 0.0)
        val descricao = intent.getStringExtra("descricaoIMC")


        val resultadoTextView: TextView = findViewById(R.id.resultadoTextView)
        resultadoTextView.text = "IMC: %.2f\n%s".format(imc, descricao)


    }
}
