# 📱 Aplicação de Opiniões de Jogos – Relatório de Desenvolvimento

## 1. Introdução  
A **Aplicação de Opiniões de Jogos** foi desenvolvida com o objetivo de criar uma plataforma onde utilizadores podem **registar-se, fazer login e deixar comentários** sobre jogos. A aplicação permite que outros utilizadores visualizem estas opiniões, promovendo a partilha de experiências e sugestões.  

Este projeto foi criado no âmbito de um trabalho académico, com a integração de tecnologias como **Firebase** para autenticação e base de dados, e o padrão de arquitetura **MVVM (Model-View-ViewModel)**, que facilita a manutenção e escalabilidade da aplicação.  

---

### 🔧 **Tecnologias Utilizadas:**  
- **Linguagem:** Kotlin  
- **Framework:** Android SDK  
- **Base de Dados:** Firebase Firestore  
- **Autenticação:** Firebase Authentication  
- **Padrão de Arquitetura:** MVVM  
- **IDE:** Android Studio  

---

### 🎯 **Objetivo do Projeto:**  
O principal objetivo é desenvolver uma aplicação funcional que:  
- Permita **login e registo** de utilizadores.  
- Proporcione um espaço para **adicionar comentários** sobre jogos.  
- Apresente um **design apelativo** e intuitivo, com uma interface gráfica bem estruturada.  

---

## 2. Planeamento e Requisitos  

### 📋 **Requisitos Funcionais:**  
- Registo e Login de utilizadores.  
- Possibilidade de adicionar comentários a jogos.  
- Visualização de comentários por outros utilizadores.  
- **Sincronização em tempo real** com Firebase Firestore.  

### ⚙️ **Requisitos Não Funcionais:**  
- Interface simples, limpa e funcional.  
- Responsividade e compatibilidade com **dispositivos Android (API mínima 21)**.  
- Implementação do padrão **MVVM** para separar a lógica de negócio da interface gráfica.  

---

### 🔄 **Modelo MVVM:**  
Este projeto segue o padrão **MVVM (Model-View-ViewModel)**, que permite uma clara separação de responsabilidades:  
- **Model:** Representa os dados e a lógica de negócio.  
- **View:** Interface com o utilizador (UI).  
- **ViewModel:** Faz a ponte entre a View e o Model, tratando da lógica de apresentação e interação com a base de dados.  

A utilização deste modelo facilita a manutenção e expansão do projeto, permitindo adicionar novas funcionalidades sem comprometer a estrutura existente.  

---
## 3. Arquitetura e Organização do Projeto 📐

A aplicação foi desenvolvida com base na arquitetura **MVVM (Model-View-ViewModel)**, promovendo a separação de responsabilidades e facilitando a manutenção e escalabilidade do projeto.

### 🏗️ Estrutura Geral do Projeto:
A estrutura do projeto está organizada de forma a manter uma clara divisão entre as diferentes camadas.

---

### 🧩 Descrição das Camadas:
- **Model (Modelo):**  
  Contém as **classes de dados** que representam as entidades do sistema, como `Comment` e `Game`.   
  - Exemplo: `Comment.kt` define a estrutura dos comentários.

- **ViewModel:**  
  A camada `ViewModel` atua como um intermediário entre a `View` e os dados (Model). Gere a lógica de negócio e comunica com o repositório para buscar ou guardar dados no Firestore.  
  - Exemplo: `DetailViewModel.kt` é responsável por carregar e adicionar comentários.

- **View (UI):**  
  A camada `UI` contém as **Activities** e Adapters, sendo responsável por renderizar a interface e reagir às interações do utilizador.  
  - Exemplo: `DetailActivity.kt` exibe os comentários e permite adicionar novos.

- **Repository (Repositório):**  
  Os repositórios fazem a **ponte entre o ViewModel e o Firestore**. Centralizam o acesso aos dados, garantindo que a lógica de acesso a dados é consistente e reutilizável.  
  - Exemplo: `CommentRepository.kt` lida com a adição e leitura de comentários no Firestore.

- **Utils (Utilitários):**  
  Contém classes auxiliares e helpers, como `FirestoreHelper`, para simplificar a interação com o Firebase.

---

### 📄 Exemplo Prático:
Quando um utilizador comenta um jogo:
1. O `DetailActivity` captura o input.  
2. Envia o comentário para o `DetailViewModel`.  
3. O `ViewModel` comunica com o `CommentRepository` para guardar o comentário.  
4. O `FirestoreHelper` é utilizado para interagir diretamente com o Firestore.  
5. Após o sucesso, o comentário é exibido no `RecyclerView` através do `CommentAdapter`.

---

### 🎯 Vantagens da Arquitetura MVVM:
- **Separação de responsabilidades.**  
- **Facilidade de teste e manutenção.**  
- **Escalabilidade** à medida que novas funcionalidades são adicionadas.  
- **Reutilização de código** com ViewModels partilhados por múltiplas Views.

---

Queres que eu avance para a próxima secção do relatório ou há algum ponto nesta secção que gostavas de aprofundar?



