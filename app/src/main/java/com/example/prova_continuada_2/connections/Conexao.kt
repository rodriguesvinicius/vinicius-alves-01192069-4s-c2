package com.example.prova_continuada_2.connections

import com.example.prova_continuada_2.connections.controllers.CachorroRequest
import com.example.prova_continuada_2.connections.models.Cachorro
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Conexao {

    private const val backend : String = "https://5f861cfdc8a16a0016e6aacd.mockapi.io/bandtec-api/"

    fun request() : CachorroRequest {
        return Retrofit.Builder()
            .baseUrl(backend)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(CachorroRequest::class.java)
    }
}