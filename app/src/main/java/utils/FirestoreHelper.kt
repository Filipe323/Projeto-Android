package com.example.aplicaoopiniopt01.utils

import com.example.aplicaoopiniopt01.model.Comment
import com.google.firebase.firestore.FirebaseFirestore

// Classe auxiliar para interagir com o Firestore
class FirestoreHelper {

    // Inicializa a instância do Firestore
    val db = FirebaseFirestore.getInstance()

    // Função para adicionar um comentário ao Firestore
    fun addComment(comment: Comment, onResult: (Boolean, String?) -> Unit) {
        db.collection("comments")  // Acede à coleção 'comments' no Firestore
            .add(comment)  // Adiciona o comentário à coleção
            .addOnSuccessListener {
                // Callback indica sucesso ao adicionar o comentário
                onResult(true, "Comentário adicionado com sucesso!")
            }
            .addOnFailureListener { e ->
                // Em caso de erro, chama o callback com a mensagem do erro
                onResult(false, e.localizedMessage)
            }
    }
}
