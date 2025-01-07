#  Aplicação de Opiniões de Jogos – Relatório de Desenvolvimento

## 1. Introdução  
A **Aplicação de Opiniões de Jogos** foi desenvolvida com o objetivo de criar uma plataforma onde utilizadores podem **registar-se, fazer login e deixar comentários** sobre jogos. A aplicação permite que outros utilizadores visualizem estas opiniões, promovendo a partilha de experiências e sugestões.  

Este projeto foi criado no âmbito de um trabalho académico, com a integração de tecnologias como **Firebase** para autenticação e base de dados, e o padrão de arquitetura **MVVM (Model-View-ViewModel)**, que facilita a manutenção e escalabilidade da aplicação.  

---

###  **Tecnologias Utilizadas:**  
- **Linguagem:** Kotlin  
- **Framework:** Android SDK  
- **Base de Dados:** Firebase Firestore  
- **Autenticação:** Firebase Authentication  
- **Padrão de Arquitetura:** MVVM  
- **IDE:** Android Studio  

---

### **Objetivo do Projeto:**  
O principal objetivo é desenvolver uma aplicação funcional que:  
- Permita **login e registo** de utilizadores.  
- Proporcione um espaço para **adicionar comentários** sobre jogos.  
- Apresente um **design apelativo** e intuitivo, com uma interface gráfica bem estruturada.  

---

## 2. Planeamento e Requisitos  

###  **Requisitos Funcionais:**  
- Registo e Login de utilizadores.  
- Possibilidade de adicionar comentários a jogos.  
- Visualização de comentários por outros utilizadores.  
- **Sincronização em tempo real** com Firebase Firestore.  

### **Requisitos Não Funcionais:**  
- Interface simples, limpa e funcional.  
- Responsividade e compatibilidade com **dispositivos Android (API mínima 21)**.  
- Implementação do padrão **MVVM** para separar a lógica de negócio da interface gráfica.  

---

###  **Modelo MVVM:**  
Este projeto segue o padrão **MVVM (Model-View-ViewModel)**, que permite uma clara separação de responsabilidades:  
- **Model:** Representa os dados e a lógica de negócio.  
- **View:** Interface com o utilizador (UI).  
- **ViewModel:** Faz a ponte entre a View e o Model, tratando da lógica de apresentação e interação com a base de dados.  

A utilização deste modelo facilita a manutenção e expansão do projeto, permitindo adicionar novas funcionalidades sem comprometer a estrutura existente.  

---
## 3. Arquitetura e Organização do Projeto 📐

A aplicação foi desenvolvida com base na arquitetura **MVVM (Model-View-ViewModel)**, promovendo a separação de responsabilidades e facilitando a manutenção e escalabilidade do projeto.

###  Estrutura Geral do Projeto:
A estrutura do projeto está organizada de forma a manter uma clara divisão entre as diferentes camadas.

---

###  Descrição das Camadas:
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

###  Exemplo Prático:
Quando um utilizador comenta um jogo:
1. O `DetailActivity` captura o input.  
2. Envia o comentário para o `DetailViewModel`.  
3. O `ViewModel` comunica com o `CommentRepository` para guardar o comentário.  
4. O `FirestoreHelper` é utilizado para interagir diretamente com o Firestore.  
5. Após o sucesso, o comentário é exibido no `RecyclerView` através do `CommentAdapter`.

---

###  Vantagens da Arquitetura MVVM:
- **Separação de responsabilidades.**  
- **Facilidade de teste e manutenção.**  
- **Escalabilidade** à medida que novas funcionalidades são adicionadas.  
- **Reutilização de código** com ViewModels partilhados por múltiplas Views.

---
## 4. Funcionalidades Implementadas 

A aplicação conta com diversas funcionalidades essenciais que garantem uma experiência completa e intuitiva para o utilizador.  
Estas funcionalidades foram projetadas para atender aos requisitos do projeto, com integração direta ao Firebase Firestore.

---

###  Lista de Funcionalidades:
- ** Autenticação de Utilizador (Login/Registo):**  
  - Os utilizadores podem criar uma conta e fazer login através de autenticação com email e password.  
  - A validação de campos e mensagens de erro informam o utilizador de forma clara.  
  - **Firebase Authentication** é utilizado para gerir a autenticação.  
  - Após o login, o utilizador é redirecionado para a tela principal (`MainActivity`).  

- ** Comentários nos Jogos:**  
  - Os utilizadores podem adicionar comentários aos jogos através de um formulário intuitivo.  
  - Os comentários são guardados no Firestore e exibidos em tempo real, mesmo que o utilizador saia da aplicação e volte mais tarde.  
  - Utiliza `RecyclerView` para apresentar a lista de comentários de forma dinâmica.  

- ** Listagem de Jogos:**  
  - Uma lista de jogos é apresentada na `MainActivity`, permitindo ao utilizador selecionar um jogo para ver os detalhes e os comentários associados.  

- ** Integração com Firebase Firestore:**  
  - A aplicação comunica diretamente com o **Firestore** para guardar e carregar dados.  
  - Os comentários e informações de cada jogo são persistidos no Firestore, garantindo uma experiência de utilizador consistente.  

---

### Personalização da Interface:  
- **Tema Visual:**  
  A interface foi personalizada com base em elementos gráficos que remetem à nostalgia dos jogos retro. A tela de login apresenta um fundo personalizado (`background_login`) que destaca a aplicação visualmente.  
  - Botões e campos de texto possuem cores, margens e padding ajustados para garantir **usabilidade** e **legibilidade**.  

---

## 5. Requisitos Técnicos Atendidos 

A aplicação cumpre com os requisitos técnicos estabelecidos inicialmente, cobrindo tanto funcionalidades essenciais quanto práticas de desenvolvimento.  

---

###  Requisitos Funcionais:  
- **Registo e Login de Utilizadores.**  
- **Adição de Comentários a Jogos.**  
- **Persistência de Dados com Firebase Firestore.**  
- **Listagem Dinâmica de Jogos e Comentários.**  

---

###  Requisitos Não Funcionais:  
- **Arquitetura MVVM (Model-View-ViewModel)** garantindo separação de responsabilidades.  
- **Interface Intuitiva e Visualmente Atraente.**  
- **Acessibilidade e Experiência do Utilizador.**  
- **Segurança na Autenticação (Firebase Authentication).**  

---
## 6. Metodologia de Desenvolvimento  

Para o desenvolvimento da aplicação, foi utilizada a **metodologia ágil**, permitindo flexibilidade e adaptações ao longo do ciclo de desenvolvimento.  

### Ciclo Iterativo e Incremental:  
O projeto foi dividido em pequenas partes (sprints) que resultaram em incrementos funcionais da aplicação a cada ciclo. Isso possibilitou:  
- **Feedback constante** com base em testes regulares.  
- **Correção de erros** e ajustes de funcionalidades durante o processo.  
- **Adição de novas features** sem comprometer a estabilidade do projeto.  

###  Etapas do Desenvolvimento:  
1. **Planeamento e Levantamento de Requisitos**  
   - Definição dos objetivos principais e funcionalidades desejadas (pesquisa de jogos, login, e comentários).  
2. **Criação de Protótipo**  
   - Protótipo inicial desenvolvido com base na estrutura de layouts XML, focando na interface principal.  
3. **Desenvolvimento e Implementação**  
   - Implementação incremental das funcionalidades, começando pelo login, pesquisa de jogos e comentários.  
4. **Testes e Correções**  
   - Realização de testes de interface, autenticação de utilizadores e persistência de dados no Firebase Firestore.  
5. **Entrega e Avaliação**  
   - Validação do produto final, garantindo que todos os requisitos foram cumpridos.  

###  Divisão do Projeto em Módulos:  
- **Frontend (UI):** Desenvolvimento das telas de login, registo e pesquisa com XML.  
- **Backend (Lógica):** Implementação das chamadas à Steam API, autenticação Firebase e manipulação de dados com ViewModel.  
- **Persistência de Dados:** Utilização do Firestore para salvar e recuperar comentários.  

---

## 7. Tecnologias e Ferramentas Utilizadas 

Durante o desenvolvimento da aplicação, foi utilizado um conjunto de tecnologias modernas e ferramentas que garantem uma arquitetura sólida, escalável e de fácil manutenção.  

---

###  Principais Tecnologias:  

- **Kotlin**  
  - Linguagem de programação principal utilizada no desenvolvimento da aplicação Android.  
  - Escolhida pela sua sintaxe concisa, interoperabilidade com Java e forte suporte nativo para Android.  

- **Android Studio**  
  - Ambiente de Desenvolvimento Integrado (IDE) utilizado para codificação, depuração e execução da aplicação.  
  - Ferramentas integradas facilitam o design de layouts, organização de recursos e gestão de dependências.  

- **Firebase Firestore**  
  - Base de dados NoSQL utilizada para armazenar e sincronizar dados em tempo real.  
  - Permite a persistência dos comentários e informações dos jogos.  

- **Firebase Authentication**  
  - Utilizado para implementar o sistema de registo e login de utilizadores com email e password.  
  - Proporciona uma abordagem segura e simplificada para autenticação de utilizadores.  

- **RecyclerView**  
  - Utilizado para exibir listas dinâmicas e permite a visualização de comentários de forma eficiente.  
  - Suporta grandes volumes de dados e implementa o padrão ViewHolder para otimização de desempenho.  

- **ViewModel (MVVM)**  
  - Implementação do padrão MVVM (Model-View-ViewModel) para garantir separação de responsabilidades.  
  - **ViewModel** gerencia a lógica e os dados da interface de utilizador, mantendo o ciclo de vida dos componentes.  

---

###  Bibliotecas e Dependências:  

- **Material Components**  
  - Utilizado para melhorar a experiência visual e interativa da aplicação, implementando botões, caixas de texto e outros componentes com design moderno.  

- **Coroutines**  
  - Garante operações assíncronas de forma eficiente, sendo utilizado para chamadas de rede e interações com o Firebase.  
  - Evita o bloqueio da interface do utilizador ao lidar com operações demoradas.  

- **Gson**  
  - Biblioteca de serialização/deserialização de objetos JSON, facilitando a comunicação com APIs externas (como a Steam API).  

---

###  Ferramentas Auxiliares:  

- **Git/GitHub**  
  - Utilizado para controlo de versão do projeto e colaboração.  
  - O código é versionado e mantido num repositório GitHub, permitindo histórico de alterações e colaboração em equipa.  

- **Canva/GIMP**  
  - Utilizado para criação e edição de imagens de fundo e ícones personalizados.  
  - Adiciona elementos gráficos que tornam a aplicação mais apelativa visualmente.  

- **Postman**  
  - Ferramenta utilizada para testar endpoints de APIs durante a implementação da funcionalidade de busca de jogos.  

---

###  Serviços Externos:  

- **Steam Web API**  
  - API utilizada para listar jogos e obter dados em tempo real diretamente da Steam.  
  - Permite a integração de funcionalidades que buscam jogos por nome, melhorando a experiência do utilizador.  

