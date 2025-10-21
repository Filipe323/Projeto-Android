package com.example.aplicaoopiniopt01.model

import com.google.firebase.Timestamp

// Data class para representar um comentário associado a um jogo
data class Comment(
    val gameId: String = "",  // ID do jogo ao qual o comentário está associado
    val comment: String = "",  // Texto do comentário
    val userId: String = "",  // ID do utilizador que fez o comentário
    val timestamp: Timestamp = Timestamp.now()  // Data e hora em que o comentário foi criado (padrão: momento atual)
)
