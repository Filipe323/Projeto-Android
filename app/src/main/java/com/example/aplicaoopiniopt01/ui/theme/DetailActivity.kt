package com.example.aplicaoopiniopt01.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.aplicaoopiniopt01.R
import com.example.aplicaoopiniopt01.model.Comment
import com.example.aplicaoopiniopt01.viewmodel.DetailViewModel

class DetailActivity : AppCompatActivity() {

    // Declaração de variáveis para componentes do layout
    private lateinit var gameTitleEditText: EditText
    private lateinit var commentEditText: EditText
    private lateinit var saveButton: Button
    private lateinit var commentsRecyclerView: RecyclerView
    private lateinit var adapter: CommentAdapter

    // ViewModel para gerir os dados e lógica da interface
    private val viewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)  // Define o layout a ser utilizado

        // Associa as variáveis aos elementos do layout
        gameTitleEditText = findViewById(R.id.gameTitleEditText)
        commentEditText = findViewById(R.id.commentEditText)
        saveButton = findViewById(R.id.saveButton)
        commentsRecyclerView = findViewById(R.id.commentsRecyclerView)

        // Obtém o nome do jogo passado pela Intent
        val gameId = intent.getStringExtra("GAME_NAME") ?: ""

        // Configuração inicial do RecyclerView para mostrar a lista de comentários
        adapter = CommentAdapter(emptyList())  // Inicializa o adaptador com uma lista vazia
        commentsRecyclerView.layoutManager = LinearLayoutManager(this)
        commentsRecyclerView.adapter = adapter

        // Observa as mudanças na lista de comentários através do ViewModel
        viewModel.comments.observe(this, Observer { comments ->
            adapter.updateComments(comments)  // Atualiza a RecyclerView com os novos comentários
        })

        // Carrega os comentários do jogo assim que a atividade inicia
        viewModel.loadComments(gameId)

        // Define a ação do botão de guardar comentário
        saveButton.setOnClickListener {
            val commentText = commentEditText.text.toString()
            if (commentText.isNotEmpty()) {
                // Cria um objeto de comentário com os dados inseridos
                val comment = Comment(
                    gameId = gameId,
                    comment = commentText,
                    userId = "user@example.com"  // Substituir pelo ID real do utilizador autenticado
                )
                // Adiciona o comentário ao Firestore através do ViewModel
                viewModel.addComment(comment) { success ->
                    if (success) {
                        commentEditText.text.clear()  // Limpa o campo de texto após sucesso
                        viewModel.loadComments(gameId)  // Recarrega os comentários para atualizar a lista
                    }
                }
            }
        }
    }
}
