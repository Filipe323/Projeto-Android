package com.example.aplicaoopiniopt01.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

// Objeto responsável por configurar e fornecer acesso à API da Steam
object SteamApiService {

    // Inicializa o Retrofit com a base URL da API da Steam
    private val api = Retrofit.Builder()
        .baseUrl("https://api.steampowered.com/")  // URL base para chamadas à API da Steam
        .addConverterFactory(GsonConverterFactory.create())  // Converte JSON em objetos Kotlin usando Gson
        .build()  // Constrói a instância Retrofit
        .create(SteamApi::class.java)  // Cria uma implementação da interface SteamApi

    // Função para pesquisar jogos pelo nome
    suspend fun searchGameByName(name: String): List<String> {
        // Faz a chamada à API para obter a lista de jogos
        val response = api.searchGames(name)

        // Filtra os jogos que contêm o nome fornecido (ignorando maiúsculas e minúsculas)
        // Retorna uma lista com o nome dos jogos filtrados
        return response.applist.apps
            .filter { it.name.contains(name, ignoreCase = true) }
            .map { it.name }
    }
}
