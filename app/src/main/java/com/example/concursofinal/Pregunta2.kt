package com.example.concursofinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner


class Pregunta2 : AppCompatActivity() {
    private var puntos :Int = 0
    private lateinit var nombre :String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pregunta2)
        nombre = intent.getStringExtra("nombre").toString()
        puntos = intent.getIntExtra("puntos",puntos)
        spinnerListener()
    }


    fun spinnerListener() {
        var spin = findViewById<Spinner>(R.id.sp)
        spin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                when (p2) {
                    1 -> {
                        puntos+=1
                        fin()
                    }
                    2 -> {
                        puntos+=2
                        fin()
                    }
                    3 -> {
                        puntos+=3
                        fin()
                    }
                    4 -> {
                        puntos+=4
                        fin()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }

    }


    private fun fin() {


        intent = Intent(this, Pregunta3::class.java).apply{
            putExtra("nombre" , nombre)
            putExtra("puntos", puntos)
        }
        startActivity(intent)

    }


}
