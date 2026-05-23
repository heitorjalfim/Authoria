# Gestão de Biblioteca API

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring](https://img.shields.io/badge/Spring_Boot-3.0-green)
![Status](https://img.shields.io/badge/Status-Em_Desenvolvimento-yellow)

API REST desenvolvida com Spring Boot para gerenciar um acervo de livros e seus respectivos autores. O projeto foca em boas práticas de arquitetura em camadas e validação de dados.

## Tecnologias
- **Java 17**
- **Spring Boot 3**
- **Spring Data JPA** 
- **H2 Database**
- **Lombok**
- **Bean Validation**

## Estrutura do Projeto
O projeto segue o padrão de camadas:
- `Controller`: Porta de entrada da API e definição dos Endpoints.
- `Service`: Camada de regras de negócio e validações.
- `Repository`: Interface de comunicação com o banco de dados.
- `Model`: Entidades que representam as tabelas do banco.

## Endpoints Principais
### Autores
- `GET /autores` - Lista todos os autores cadastrados.
- `POST /autores` - Cadastra um novo autor (Valida nome e nacionalidade).
- `GET /autores/{id}` - Busca um autor específico.

### Livros
- `GET /livros` - Lista todos os livros.
- `POST /livros` - Cadastra um novo livro (Valida título, ano e autor).
