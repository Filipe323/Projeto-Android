package com.example.aplicaoopiniopt01.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicaoopiniopt01.R

// Adaptador para exibir a lista de jogos no RecyclerView
class GameListAdapter(
    private var gameList: List<String>,               // Lista de jogos que será exibida
    private val onItemClick: (String) -> Unit         // Função de clique para cada item
) : RecyclerView.Adapter<GameListAdapter.GameViewHolder>() {

    // ViewHolder representa cada item individual do RecyclerView
    inner class GameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val gameNameTextView: TextView = itemView.findViewById(R.id.gameNameTextView)
        // gameNameTextView: Elemento TextView do layout que mostrará o nome do jogo
    }

    // Criação do ViewHolder – Infla o layout do item (item_game.xml) para cada elemento da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_game, parent, false)  // Infla o layout para cada item da lista
        return GameViewHolder(view)  // Retorna uma nova instância do ViewHolder
    }

    // Liga (associa) os dados do jogo a cada ViewHolder quando o item é exibido na tela
    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.gameNameTextView.text = gameList[position]  // Define o texto do item (nome do jogo)

        // Define a ação de clique para cada item da lista
        holder.itemView.setOnClickListener {
            onItemClick(gameList[position])  // Passa o nome do jogo selecionado para a função de clique
        }
    }

    // Retorna o número total de itens na lista
    override fun getItemCount(): Int {
        return gameList.size
    }

    // Método para atualizar a lista de jogos no RecyclerView e notificar a interface sobre a mudança
    fun updateGames(newGames: List<String>) {
        gameList = newGames  // Atualiza a lista de jogos
        notifyDataSetChanged()  // Notifica o RecyclerView para redesenhar a lista com os novos dados
    }
}
