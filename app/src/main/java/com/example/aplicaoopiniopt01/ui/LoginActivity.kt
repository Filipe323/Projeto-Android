package com.example.aplicaoopiniopt01.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.aplicaoopiniopt01.R
import com.example.aplicaoopiniopt01.utils.FirebaseAuthHelper

class LoginActivity : AppCompatActivity() {

    // Declaração de variáveis para componentes do layout
    private lateinit var emailEditText: EditText  // Campo de texto para email
    private lateinit var passwordEditText: EditText  // Campo de texto para password
    private lateinit var loginButton: Button  // Botão para login
    private lateinit var signUpButton: Button  // Botão para registo
    private lateinit var firebaseAuthHelper: FirebaseAuthHelper  // Helper para lidar com autenticação Firebase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)  // Define o layout associado à atividade

        // Inicializa as Views ligando-as ao layout (R.layout.activity_login)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)
        signUpButton = findViewById(R.id.signUpButton)

        // Inicializa o helper do Firebase para autenticação
        firebaseAuthHelper = FirebaseAuthHelper(this)

        // Define a ação do botão de login
        loginButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Verifica se o email e a password foram preenchidos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Tenta fazer login com Firebase
                firebaseAuthHelper.signIn(email, password) { success, message ->
                    if (success) {
                        // Se o login for bem-sucedido, redireciona para MainActivity
                        Toast.makeText(this, "Login bem-sucedido!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()  // Termina a atividade de login para não voltar atrás
                    } else {
                        // Exibe mensagem de erro caso o login falhe
                        Toast.makeText(this, "Erro: $message", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // Se campos estiverem vazios, mostra uma notificação (Toast)
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }

        // Define a ação do botão de registo
        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Verifica se o email e a password foram preenchidos
            if (email.isNotEmpty() && password.isNotEmpty()) {
                // Tenta registar o utilizador no Firebase
                firebaseAuthHelper.signUp(email, password) { success, message ->
                    if (success) {
                        // Se o registo for bem-sucedido, redireciona para MainActivity
                        Toast.makeText(this, "Registo bem-sucedido!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()  // Termina a atividade após registo
                    } else {
                        // Mostra mensagem de erro caso o registo falhe
                        Toast.makeText(this, "Erro: $message", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {
                // Alerta o utilizador se algum campo não estiver preenchido
                Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
