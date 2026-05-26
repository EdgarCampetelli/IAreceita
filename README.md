# 🥗 IA Receita - Gerenciamento de Estoque Inteligente com IA

![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Gemini](https://img.shields.io/badge/google_gemini-%238E75C2.svg?style=for-the-badge&logo=googlegemini&logoColor=white)

O **IA Receita** é uma aplicação completa de gerenciamento de estoque de alimentos (CRUD) desenvolvida com o ecossistema Spring. O grande diferencial do projeto é a sua integração com a API do **Google Gemini (IA Generativa)**: através de um fluxo reativo e não-bloqueante, o sistema analisa os ingredientes disponíveis no banco de dados e gera receitas criativas e personalizadas instantaneamente para o usuário.

---

## 🎯 Funcionalidades

* **CRUD Completo de Alimentos:** Cadastro, listagem, edição e exclusão de itens de consumo (Nome, Categoria, Quantidade e Validade).
* **Interface Dinâmica Integrada:** Telas limpas e responsivas construídas com Thymeleaf e CSS Puro, utilizando controle de estados por modais (sem dependência de frameworks pesados).
* **Geração de Receitas com IA:** Um assistente inteligente que consome a API do Gemini via requisições assíncronas para sugerir pratos baseados no estoque atual.
* **Efeitos de Estado em Tempo Real:** Botão de carregamento adaptativo (*spinner*) enquanto a IA processa o payload de resposta.

---

## 🛠️ Stack Técnica

* **Linguagem:** Java 17+
* **Framework Base:** Spring Boot 3
* **Web & Reatividade:** Spring WebFlux (`WebClient`)
* **Persistência de Dados:** Spring Data JPA
* **Banco de Dados:** H2 Database (Em memória com persistência volátil guiada por sessão)
* **Template Engine:** Thymeleaf (com extensão `thymeleaf-extras-java8time` para tratamento de `LocalDateTime`)
* **Parser de JSON:** Jackson Node / ObjectMapper
* **Facilitadores de Código:** Lombok (Getters, Setters e Construtores)

---

## 🏗️ Arquitetura do Sistema

O projeto adota uma arquitetura em camadas bem definida, garantindo baixo acoplamento e separação de responsabilidades:

1.  **Model / Entity:** Representação estrita das tabelas do banco H2 (`FooditemModel`).
2.  **DTO (Data Transfer Object):** Segurança e controle no tráfego de dados para a View (`FooditemDTO`).
3.  **Mapper Component:** Camada isolada responsável pela conversão bidirecional segura entre Entidades e DTOs, evitando o vazamento de referências nulas.
4.  **Repository:** Interface de abstração de query baseada no `JpaRepository`.
5.  **Service Layer:** Onde reside a lógica de negócios da aplicação (`FooditemService`) e a gerência do consumo de APIs externas através do `WebClient` reativo (`GeminiService`).
6.  **Controllers:** Divisão clara entre o controlador de Views do Thymeleaf (`FooditemViewController`) e o processamento de respostas assíncronas (`@ResponseBody`).

---

<img width="1875" height="953" alt="image" src="https://github.com/user-attachments/assets/1419ce27-ac3b-4822-8813-620c792304e6" />
<img width="1874" height="948" alt="image" src="https://github.com/user-attachments/assets/47b53863-b915-4cde-91b3-557bc1849c6c" />
<img width="1875" height="945" alt="image" src="https://github.com/user-attachments/assets/f33df8e3-ea39-4a0c-b528-ebc243a92a6d" />
<img width="1874" height="949" alt="image" src="https://github.com/user-attachments/assets/70bc5930-1ac5-48ab-92f6-0911c5bf7011" />
<img width="1874" height="950" alt="image" src="https://github.com/user-attachments/assets/86c7fb8f-e90e-4228-b4ef-c10e1aedc5e0" />
