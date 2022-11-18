package com.example.concursofinal

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.concursofinal.databinding.ActivityFinalBinding
import java.io.IOException
import java.io.OutputStreamWriter

class Final : AppCompatActivity() {

    private lateinit var nombre :String
    private  var puntos :Int = 0
    private lateinit var player:String
    private lateinit var heroe:String
    private lateinit var binding: ActivityFinalBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var imagen = binding.imgView

        nombre = intent.getStringExtra("nombre").toString()
        puntos = intent.getIntExtra("puntos",puntos)

        var text: TextView = binding.tvSaludo
        if(puntos<3) {
                heroe = "IronMan"
                imagen.setImageResource(R.drawable.ironman)
            }
        else if(puntos<6){
                heroe = "SpiderMan"
                imagen.setImageResource(R.drawable.spiderman)
            }
        else if(puntos<9){
                heroe = "Thor"
                imagen.setImageResource(R.drawable.thor)
            }
        else{
                heroe = "Dr Strange"
                imagen.setImageResource(R.drawable.drstrange)
            }


        text.text= "Enhorabuena $nombre\nTu SuperHeroe ideal es $heroe"

        player = "$nombre,$heroe\n"

        binding.btnGuardar.setOnClickListener{
            guardar()
        }

    }
    fun guardar()
    {
        val arc = "puntuaciones.csv"

        try
        {
            val escritor = OutputStreamWriter(openFileOutput(arc, Context.MODE_APPEND))

            escritor.write(player)

            escritor.flush()
            escritor.close()

            Toast.makeText(this, "Puntuación grabada", Toast.LENGTH_SHORT).show()
        }
        catch (e:IOException)
        {
            e.stackTrace
        }

        intent = Intent(this, Foto::class.java).apply {
            putExtra("nombre", nombre)
            putExtra("heroe", heroe)
        }
        startActivity(intent)
    }

    }
