package com.example.aplicaoopiniopt01.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.aplicaoopiniopt01.model.Comment
import com.example.aplicaoopiniopt01.utils.FirestoreHelper

// ViewModel responsável por gerir a lógica de negócios e interação com o Firestore
class DetailViewModel : ViewModel() {

    // Instância do FirestoreHelper para interagir com a base de dados
    private val firestoreHelper = FirestoreHelper()

    // LiveData que armazena a lista de comentários e permite a observação por outras classes (ex: Activities)
    private val _comments = MutableLiveData<List<Comment>>()
    val comments: LiveData<List<Comment>> get() = _comments  // LiveData público, apenas leitura

    // Função para carregar comentários de um jogo específico
    fun loadComments(gameId: String) {
        firestoreHelper.db.collection("comments")  // Acede à coleção 'comments' no Firestore
            .whereEqualTo("gameId", gameId)  // Filtra os comentários pelo ID do jogo
            .get()
            .addOnSuccessListener { documents ->
                // Converte os documentos Firestore para objetos Comment e atualiza o LiveData
                _comments.value = documents.toObjects(Comment::class.java)
            }
            .addOnFailureListener {
                // Em caso de falha, retorna uma lista vazia, prevenindo erros na interface
                _comments.value = emptyList()
            }
    }

    // Função para adicionar um novo comentário
    fun addComment(comment: Comment, onResult: (Boolean) -> Unit) {
        // Adiciona o comentário ao Firestore através do helper
        firestoreHelper.addComment(comment) { success, _ ->
            if (success) {
                // Recarrega a lista de comentários se a adição for bem-sucedida
                loadComments(comment.gameId)
            }
            // Chama o callback com o resultado da operação
            onResult(success)
        }
    }
}
