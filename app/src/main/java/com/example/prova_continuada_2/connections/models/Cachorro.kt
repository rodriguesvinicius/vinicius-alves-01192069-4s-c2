package com.example.prova_continuada_2.connections.models

import com.google.gson.annotations.SerializedName

data class Cachorro(
    @SerializedName("id") var id : String,
    @SerializedName("raca") var raca : String,
    @SerializedName("precoMedio") var precoMedio : Double,
    @SerializedName("indicadoCriancas") var indicacao : Boolean
)