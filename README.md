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

👉 **Próximo Passo:**  
- No ponto seguinte, vamos detalhar a **arquitetura e organização do projeto**, explicando a estrutura de pastas e os ficheiros principais.  
