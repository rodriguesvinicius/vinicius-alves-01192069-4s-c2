package com.example.prova_continuada_2

import android.graphics.Color
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.prova_continuada_2.connections.Conexao
import com.example.prova_continuada_2.connections.responses.CachorroResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListarCachorro : AppCompatActivity() {
    private val createDog = Conexao.request()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_cachorro)

        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)
                // .enqueue() abre um processo ASSÍNCRONO (ou seja, paralelo, não "trava" a tela)
        createDog.findAllDogs().enqueue(object : Callback<List<CachorroResponse>> { // retrofit2.Callback

            // onResponse é executando se chamada for feita com sucesso
            override fun onResponse(call: Call<List<CachorroResponse>>, response: Response<List<CachorroResponse>>) {

                // response.body() -> obtém o corpo da resposta
                response.body()?.forEach {

                    // criando uma nova TextView
                    val tvDog = TextView(baseContext)
                    tvDog.text = "Id: ${it.id} - raca: ${it.raca} - precoMedio: ${it.precoMedio} - indicado ${it.indicadoCriancas}"
                    tvDog.setTextColor(Color.parseColor("#9911AA"))

                    // adicionando a nova TextView no LinearLayout
                    layoutLista.addView(tvDog)
                }

            }

            // onFailure é executado se houver erro na chamada
            override fun onFailure(call: Call<List<CachorroResponse>>, t: Throwable) {
                Toast.makeText(baseContext, "Erro na chamada: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}