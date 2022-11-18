package com.example.concursofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.example.concursofinal.databinding.ActivityPregunta1Binding
import com.google.android.material.dialog.MaterialAlertDialogBuilder

class Pregunta1 : AppCompatActivity() {

    private var puntos: Int = 0
    private lateinit var nombre :String
    private lateinit var binding: ActivityPregunta1Binding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)



        nombre = intent.getStringExtra("nombre")!!
        val saludo = "Bienvenido $nombre.\nVeamos a que personaje de marvel te pareces más."

        binding.usuario.text =saludo
        binding.radioIronMan.setOnClickListener{radioClick()}
        binding.radioSpiderman.setOnClickListener{radioClick()}
        binding.radioThor.setOnClickListener{radioClick()}
        binding.radioStrange.setOnClickListener{radioClick()}
    }

    fun radioClick(){

        var b1: RadioButton = binding.radioIronMan
        var b2: RadioButton = binding.radioSpiderman
        var b3: RadioButton = binding.radioThor
        var b4: RadioButton = binding.radioStrange

        if (b1.isChecked){
            puntos += 1
            llevar()
        }else if (b2.isChecked){
            puntos += 2
            llevar()
        }else if (b3.isChecked){
            puntos += 3
            llevar()
        }else if (b4.isChecked){
            puntos += 4
            llevar()
        }
        else {
            MaterialAlertDialogBuilder(this)
                .setTitle("Error selección")
                .setMessage("Tienes que seleccionar un campo")
                .setCancelable(true)
                .show()
        }
    }

    fun llevar(){
        intent = Intent(this, Pregunta2::class.java).apply {
            putExtra("nombre",nombre)
            putExtra("puntos",puntos)
        }
        startActivity(intent)
    }

}