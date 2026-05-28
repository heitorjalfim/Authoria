# 🖋️ Authoria API

![Java](https://img.shields.io/badge/Java-17-orange?style=for-the-badge&logo=java)
![Spring](https://img.shields.io/badge/Spring_Boot-3.x-green?style=for-the-badge&logo=spring)
![Architecture](https://img.shields.io/badge/Architecture-Clean_&_DDD-blue?style=for-the-badge)

API REST desenvolvida para a gestão completa de autores, publicações e o ciclo de vida de obras literárias. O grande diferencial deste projeto é a aplicação estrita de **Clean Architecture** e **Domain-Driven Design (DDD)**, garantindo um código altamente testável, desacoplado e focado no domínio do negócio.

---

## 🚀 O Roadmap do Projeto (Marcos de Evolução)

O desenvolvimento da Authoria API foi planejado estrategicamente em 4 grandes etapas de maturidade:

- [x] **Marco 1: Core Domain & REST API** -> Miolo do sistema, regras de negócio isoladas, persistência e endpoints HTTP (Concluído).
- [ ] **Marco 2: Security & Identity** -> Autenticação e autorização com Spring Security e JWT.
- [ ] **Marco 3: E-Commerce Core** -> Agregados de Domínio para Carrinho de Compras e Gestão de Estoque.
- [ ] **Marco 4: Integrations** -> Consumo de API externa de pagamento e disparos de e-mails assíncronos.

---

## 🏛️ Design Arquitetural

Para evitar o acoplamento com frameworks e garantir a manutenibilidade, a estrutura de pacotes respeita as fronteiras da **Clean Architecture**:

* **`domain`**: O coração da aplicação. Contém os Modelos de Domínio Puros (regras de vender, emprestar, etc.) e as interfaces/contratos dos Repositórios (`IAutorRepository`). Zero dependências de frameworks.
* **`application`**: Casos de uso do sistema (`Services`). Orquestram o fluxo de dados e aplicam validações de defesa rígidas antes de interagir com o domínio.
* **`api (Presentation)`**: Camada de interface com o usuário web. Contém os `Controllers` REST magros e os `DTOs` que utilizam construtores de mapeamento inteligente para garantir a imutabilidade.
* **`infrastructure`**: Detalhes técnicos e externos, como o mapeamento de entidades JPA, banco de dados e configurações específicas do Spring.

---

## 🛠️ Tecnologias e Conceitos Aplicados

- **Java 17** & **Spring Boot 3**
- **Clean Architecture & Domain-Driven Design (DDD)**
- **Inversão de Dependência (IoC)** para desacoplamento do banco de dados
- **Lombok** para redução de código boilerplate
- **Mapeamento de DTOs via Construtores Dedicados**
- **Validações de Defesa Ativas** (Prevenção contra estados inválidos e NullPointerExceptions)

---

## 📌 Endpoints do Marco 1

### 👤 Autores (`/autores`)
* `POST /autores` - Cria um autor novo com estado inicial de renda zerado.
* `GET /autores/{id}` - Busca os detalhes de um autor específico mapeado para DTO.
* `POST /autores/{autorId}/publicar-livro` - Publica uma nova obra vinculando-a diretamente ao seu autor.
* `DELETE /autores/{id}` - Remove um autor do sistema (Retorna `204 No Content`).

### 📚 Livros (`/livros`)
* `GET /livros/{id}` - Busca um livro pelo ID.
* `PATCH /livros/{id}/vender` - Executa a regra de negócio de venda no domínio do livro.
* `PATCH /livros/{id}/emprestar` - Altera o estado do livro para emprestado.
* `PATCH /livros/{id}/devolver` - Retorna o livro ao acervo disponível.
* `DELETE /livros/{id}` - Remove o registro do livro (Retorna `204 No Content`).

---
Desenvolvido por [Heitor Jalfim](www.linkedin.com/in/heitorjalfim/) 🚀
