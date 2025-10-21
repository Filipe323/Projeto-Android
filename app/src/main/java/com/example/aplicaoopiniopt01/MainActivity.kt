package com.example.aplicaoopiniopt01.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicaoopiniopt01.R
import com.example.aplicaoopiniopt01.network.SteamApiService
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    // Declaração das variáveis de interface
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: GameListAdapter
    private lateinit var searchEditText: EditText
    private lateinit var searchButton: Button
    private lateinit var auth: FirebaseAuth  // Autenticação Firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)  // Define o layout principal da atividade

        // Inicializa o FirebaseAuth para autenticação do utilizador
        auth = FirebaseAuth.getInstance()

        // Verifica se o utilizador está autenticado, se não, realiza autenticação anônima
        if (auth.currentUser == null) {
            signInAnonymously()
        } else {
            Toast.makeText(this, "Utilizador autenticado: ${auth.currentUser?.uid}", Toast.LENGTH_SHORT).show()
        }

        // Associa as Views aos seus respetivos elementos no layout
        recyclerView = findViewById(R.id.recyclerView)
        searchEditText = findViewById(R.id.searchEditText)
        searchButton = findViewById(R.id.searchButton)

        // Configura o RecyclerView com um adaptador vazio e define a ação ao clicar em um item da lista
        adapter = GameListAdapter(emptyList()) { gameName ->
            val intent = Intent(this, DetailActivity::class.java)  // Abre a tela de detalhes do jogo
            intent.putExtra("GAME_NAME", gameName)  // Passa o nome do jogo selecionado
            startActivity(intent)
        }

        // Configura o layout do RecyclerView como Linear (lista vertical)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        // Define a ação do botão de pesquisa
        searchButton.setOnClickListener {
            val query = searchEditText.text.toString()
            if (query.isNotEmpty()) {
                searchGames(query)  // Realiza a pesquisa de jogos
            } else {
                Toast.makeText(this, "Por favor, insira o nome do jogo", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Função que realiza autenticação anônima no Firebase
    private fun signInAnonymously() {
        auth.signInAnonymously()
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Autenticação anônima bem-sucedida", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(this, "Falha na autenticação: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                }
            }
    }

    // Função que realiza pesquisa de jogos através da SteamApiService
    private fun searchGames(query: String) {
        lifecycleScope.launch(Dispatchers.IO) {
            try {
                val games = SteamApiService.searchGameByName(query)  // Realiza a pesquisa na API da Steam
                withContext(Dispatchers.Main) {
                    // Atualiza a lista se houver resultados, caso contrário, exibe uma mensagem
                    if (games.isNotEmpty()) {
                        adapter.updateGames(games)
                    } else {
                        Toast.makeText(this@MainActivity, "Nenhum jogo encontrado", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                // Trata erros que possam ocorrer durante a pesquisa
                withContext(Dispatchers.Main) {
                    Toast.makeText(this@MainActivity, "Erro ao pesquisar: ${e.message}", Toast.LENGTH_LONG).show()
                }
                e.printStackTrace()  // Log de erro no console
            }
        }
    }
}
