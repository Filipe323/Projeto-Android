package com.example.aplicaoopiniopt01.repository

import com.example.aplicaoopiniopt01.network.SteamApiService
import kotlinx.coroutines.runBlocking

// Repositório responsável por lidar com a lógica de obtenção de dados
class GameRepository {

    // Função para pesquisar jogos usando uma query (nome do jogo)
    fun searchGames(query: String): List<String> {
        var result = listOf<String>()  // Inicializa a lista de resultados como vazia

        runBlocking {
            // Chama a função de pesquisa na API da Steam e guarda o resultado
            result = SteamApiService.searchGameByName(query)
        }

        // Retorna a lista de jogos encontrados
        return result
    }
}
