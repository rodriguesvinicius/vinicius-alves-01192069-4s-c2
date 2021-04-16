package com.example.prova_continuada_2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.prova_continuada_2.connections.Conexao
import com.example.prova_continuada_2.connections.models.Cachorro
import com.example.prova_continuada_2.connections.responses.CachorroResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CadastrarCachorro : AppCompatActivity() {

    private val createDog = Conexao.request()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_cachorro)
    }

    fun cadastrarDog(view: View){
        val etRaca : EditText = findViewById(R.id.et_raca)
        val etPrecoMedio : EditText = findViewById(R.id.et_preco_medio)


        val switch:Switch = findViewById(R.id.sw_indicado)

        var precoMedio : Double = 0.0
        precoMedio = if (etPrecoMedio.text.isBlank()) 0.0 else etPrecoMedio.text.toString().toDouble()

        val cachorro  = Cachorro("",etRaca.toString(),precoMedio, switch.isChecked)

        createDog.createDog(cachorro).enqueue(object : Callback<CachorroResponse> {
            override fun onResponse(
                call: Call<CachorroResponse>,
                response: Response<CachorroResponse>
            ) {
                val successo : TextView = findViewById(R.id.tv_success)
                val successo2 : ImageView = findViewById(R.id.iv_foto)
                successo.visibility
                successo2.visibility
                Toast.makeText(baseContext, "Sucesso", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<CachorroResponse>, t: Throwable) {
                Log.e("Erro", "erro " + t.message)
                Toast.makeText(baseContext, "Erro", Toast.LENGTH_SHORT).show()
            }
        })
    }

}