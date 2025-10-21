package com.example.aplicaoopiniopt01.utils

import android.content.Context
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

// Classe auxiliar para gerir autenticação Firebase
class FirebaseAuthHelper(private val context: Context) {

    // Instância do FirebaseAuth para lidar com autenticação de utilizadores
    private val auth: FirebaseAuth = FirebaseAuth.getInstance()

    // Função para login de utilizador com email e password
    fun signIn(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Chama o callback indicando sucesso
                    callback(true, null)
                } else {
                    // Em caso de falha, passa a mensagem de erro
                    callback(false, task.exception?.localizedMessage)
                }
            }
    }

    // Função para registar um novo utilizador com email e password
    fun signUp(email: String, password: String, callback: (Boolean, String?) -> Unit) {
        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    // Callback indica sucesso no registo
                    callback(true, null)
                } else {
                    // Em caso de erro, retorna a mensagem associada
                    callback(false, task.exception?.localizedMessage)
                }
            }
    }

    // Função para terminar sessão do utilizador
    fun signOut() {
        auth.signOut()
        // Mostra um Toast para indicar que a sessão foi terminada com sucesso
        Toast.makeText(context, "Sessão terminada", Toast.LENGTH_SHORT).show()
    }

    // Verifica se o utilizador está autenticado
    fun isUserLoggedIn(): Boolean {
        // Retorna true se existir um utilizador autenticado, senão retorna false
        return auth.currentUser != null
    }
}
