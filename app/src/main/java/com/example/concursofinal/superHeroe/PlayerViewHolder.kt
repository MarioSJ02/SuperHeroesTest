package com.example.concursofinal.superHeroe

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.example.concursofinal.R
import com.squareup.picasso.Picasso
import java.io.File

class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    val foto = view.findViewById<ImageView>(R.id.fotoJugador)
    val nombre = view.findViewById<TextView>(R.id.nombreJugador)
    val heroe = view.findViewById<TextView>(R.id.heroeJugador)


    fun render(
        player: Player,
    ) {
        heroe.text = player.heroe
        nombre.text = player.nombre
        val route = player.nombre + "-" + player.heroe + ".jpg"
        val uri = File("/data/data/com.example.concursofinal/files/$route")

        val uriImage = Uri.fromFile(uri)
        Picasso.with(foto.context).load(uriImage).fit().centerCrop().into(foto)


    }

}