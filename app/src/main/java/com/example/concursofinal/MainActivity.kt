package com.example.concursofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.concursofinal.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnAccederApp.setOnClickListener {
            accederApp()
        }
        binding.btnPuntos.setOnClickListener { verPuntuaciones() }
    }

    fun accederApp(){

        val usuario = binding.campoUsuario.text.toString()
        if (binding.campoUsuario.text.isEmpty())
            Toast.makeText(applicationContext,"Introduce un nombre primero",Toast.LENGTH_SHORT)
        else {
            val intent = Intent(this, Pregunta1::class.java).apply {
                putExtra("nombre",usuario)
            }
            startActivity(intent)
        }
    }

    fun verPuntuaciones()
    {
        intent = Intent(this, Puntuaciones::class.java)
        startActivity(intent)
    }
}