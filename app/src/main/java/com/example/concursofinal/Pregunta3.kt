package com.example.concursofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.concursofinal.databinding.ActivityPregunta3Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder


class Pregunta3 : AppCompatActivity() {
    private var puntos :Int = 0
    private lateinit var nombre :String
    private lateinit var binding: ActivityPregunta3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        nombre = intent.getStringExtra("nombre").toString()

        puntos = intent.getIntExtra("puntos",puntos)



        binding.btnEnv3.setOnClickListener{
            onCheckboxChecked()
        }

    }
    fun onCheckboxChecked() {
        if (binding.cb1.isChecked or binding.cb2.isChecked) {
            puntos += 1
            fin()
        } else if (binding.cb3.isChecked or binding.cb4.isChecked) {
            puntos += 2
            fin()
        }
        else if(binding.cb5.isChecked) {
            puntos += 3
            fin()
        }
        else if(binding.cb6.isChecked){
            puntos += 4
            fin()
        }
        else {
                fin()
        }


    }
    fun fin(){


        intent = Intent(this, Final::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("puntos", puntos)
        }
        startActivity(intent)
    }



}