package com.example.prova_continuada_2.connections.controllers

import com.example.prova_continuada_2.connections.models.Cachorro
import com.example.prova_continuada_2.connections.responses.CachorroResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface CachorroRequest {
    @Headers("Content-Type: application/json")
    @GET("/cachorros")
    fun findAllDogs() : Call<List<CachorroResponse>>

    @Headers("Content-Type: application/json")
    @POST(value="/cachorros")
    fun createDog(@Body cachorro: Cachorro): Call<CachorroResponse>

}