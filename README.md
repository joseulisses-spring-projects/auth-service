#  Auth Service – Spring Boot + JWT

API de autenticação desenvolvida em **Java com Spring Boot**, utilizando **Spring Security**, **JWT** e **PostgreSQL**.  
Projeto criado para portfólio backend, com foco em segurança, organização e boas práticas.

---

##  Funcionalidades

- Cadastro de usuários
- Login com email e senha
- Geração e validação de JWT
- Proteção de rotas com Spring Security
- Senhas criptografadas com BCrypt
- Persistência com PostgreSQL
- API testada via Postman

---

##  Estrutura do Projeto

```text
controller  → Endpoints REST
service     → Regras de negócio
domain
 ├─ entity      → Entidades JPA
 └─ repository  → Acesso ao banco
security    → JWT, filtros e configurações

