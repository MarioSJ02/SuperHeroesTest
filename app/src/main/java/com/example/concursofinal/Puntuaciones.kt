package com.example.concursofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concursofinal.superHeroe.Player
import com.example.concursofinal.superHeroe.PlayerAdapter
import com.example.concursofinal.superHeroe.PlayerProvider

class Puntuaciones : AppCompatActivity()
{

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_puntuaciones)

        initRecyclerView()
    }


    private fun initRecyclerView()
    {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerPlayer)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val playerProvider = PlayerProvider
        playerProvider.setContext(this)
        recyclerView.adapter = PlayerAdapter(playerProvider.fillList())
    }
}