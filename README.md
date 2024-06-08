Sistema de Votação Eleitoral com Java e Spring
Introdução
Este projeto é um sistema de votação eleitoral desenvolvido utilizando Java e o framework Spring. Ele expõe uma API RESTful que permite a gestão de candidatos, a realização de votos e a consulta dos resultados da eleição. O sistema implementa autenticação de usuários, garantindo que somente usuários autenticados possam registrar candidatos e votar.

Funcionalidades
Autenticação de Usuários

Registro de novos usuários.
Login de usuários existentes.
Proteção de endpoints com autenticação via JWT.
Gestão de Candidatos

Usuários autenticados podem registrar novos candidatos.
Visualização da lista de candidatos registrados.
Realização de Votos

Usuários autenticados podem votar em candidatos existentes.
Cada usuário pode votar apenas uma vez na eleição.
Consulta de Resultados

Os resultados da eleição podem ser consultados por qualquer usuário.
Resultados apresentados de forma agregada.

Tecnologias Utilizadas

Java: Linguagem de programação principal.
Spring Boot: Framework para construção do backend.
Spring Data JPA: Para acesso e manipulação de dados no banco de dados.
Spring Security: Para autenticação e autorização.
JWT (JSON Web Tokens): Para gestão de sessões e autenticação.
PostgreSQL: sistema gerenciador de banco de dados objeto relacional para desenvolvimento e testes.

Estrutura do Projeto

Model: Contém as entidades JPA que representam as tabelas do banco de dados.
Repository: Interfaces que extendem o JpaRepository para acesso a dados.
Service: Classes que implementam a lógica de negócio.
Controller: Controladores REST que expõem os endpoints da API.
