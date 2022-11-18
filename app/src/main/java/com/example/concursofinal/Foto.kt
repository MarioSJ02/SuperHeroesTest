package com.example.concursofinal

import android.app.Activity
import android.app.Instrumentation
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import com.example.concursofinal.databinding.ActivityFotoBinding
import java.io.IOException
import java.text.SimpleDateFormat
import java.util.*

class Foto : AppCompatActivity() {
    private lateinit var nombre:String
    private lateinit var heroe:String
    private var guardado = false
    private lateinit var binding: ActivityFotoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFotoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        nombre = intent.getStringExtra("nombre").toString()
        heroe = intent.getStringExtra("heroe").toString()

        binding.btnFoto.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }
        binding.home.setOnClickListener {
            home()

        }

    }

    private val startForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult())
    {
            result: ActivityResult ->
        if(result.resultCode == Activity.RESULT_OK)
        {
            val intent = result.data
            val imageBitmap = intent?.extras?.get("data") as Bitmap
            val imageView = findViewById<ImageView>(R.id.verFoto)
            imageView.setImageBitmap(imageBitmap)

            val fos = openFileOutput(crearNombre(), Context.MODE_PRIVATE)
            imageBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fos)
            try {
                fos.close()
            }
            catch (e: IOException){

            }

            guardado = true
        }
    }

    fun crearNombre():String
    {

        return "$nombre-$heroe.jpg"
    }

    fun home(){
        if(guardado==true){
            intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this, "Necesito una foto", Toast.LENGTH_SHORT).show()
        }
    }

}