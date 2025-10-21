package com.example.aplicaoopiniopt01.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicaoopiniopt01.R
import com.example.aplicaoopiniopt01.model.Comment

// Adaptador para exibir a lista de comentários no RecyclerView
class CommentAdapter(private var comments: List<Comment>) :
    RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    // ViewHolder que representa cada item individual da lista de comentários
    class CommentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Elementos visuais (TextViews) do layout item_comment.xml
        val commentText: TextView = itemView.findViewById(R.id.commentText)  // Mostra o texto do comentário
        val userText: TextView = itemView.findViewById(R.id.userText)        // Mostra o nome/ID do utilizador que fez o comentário
    }

    // Criação do ViewHolder – Infla o layout item_comment.xml para cada elemento da lista
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_comment, parent, false)  // Infla o layout do comentário
        return CommentViewHolder(view)  // Retorna uma nova instância do ViewHolder
    }

    // Liga (associa) os dados do comentário ao ViewHolder
    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val comment = comments[position]  // Obtém o comentário na posição atual
        holder.commentText.text = comment.comment  // Define o texto do comentário
        holder.userText.text = comment.userId      // Define o ID do utilizador que fez o comentário
    }

    // Retorna o número total de itens na lista
    override fun getItemCount() = comments.size

    // Atualiza a lista de comentários no RecyclerView e notifica que houve mudança nos dados
    fun updateComments(newComments: List<Comment>) {
        comments = newComments  // Atualiza a lista com novos comentários
        notifyDataSetChanged()  // Notifica o RecyclerView para redesenhar a lista
    }
}
