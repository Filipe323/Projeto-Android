package com.example.aplicaoopiniopt01.network

import retrofit2.http.GET
import retrofit2.http.Query

// Interface que define as chamadas para a API da Steam usando Retrofit
interface SteamApi {

    // Define uma função para obter a lista de jogos da Steam através de uma chamada GET
    @GET("ISteamApps/GetAppList/v2/")
    suspend fun searchGames(
        @Query("name") name: String  // Passa o parâmetro 'name' na query da URL para filtrar os jogos
    ): ApiResponse  // Retorna um objeto do tipo ApiResponse, que será definido para processar os dados da resposta
}
