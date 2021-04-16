package com.example.prova_continuada_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun cadastrar(view: View){
        val intent = Intent(this@MainActivity, CadastrarCachorro::class.java)
        startActivity(intent)
    }

    fun listarDogs(view: View){
        val intent = Intent(this@MainActivity, ListarCachorro::class.java)
        startActivity(intent)
    }
}