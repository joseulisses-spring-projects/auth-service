#  Auth Service – Spring Boot + JWT

API de autenticação desenvolvida em Java com Spring Boot, utilizando Spring Security, JWT e PostgreSQL.  
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

controller  → Endpoints REST  
service     → Regras de negócio  
domain  
 ├─ entity      → Entidades JPA  
 └─ repository  → Acesso ao banco  
security    → JWT, filtros e configurações  

---

##  Segurança

- Autenticação stateless com JWT
- Token enviado via header:
Authorization: Bearer <token>

yaml
Copiar código
- Filtro JWT customizado com OncePerRequestFilter
- Rotas públicas e protegidas configuradas manualmente

---

##  Tecnologias

- Java
- Spring Boot
- Spring Security
- Spring Data JPA
- JWT (jjwt)
- PostgreSQL
- Docker
- Maven

---

##  Como Executar

Subir o banco de dados:
docker-compose up -d

Rodar a aplicação:
mvn spring-boot:run

A API sobe em:
http://localhost:8080


## 🧪 Testes (Postman)

Login:
POST /auth/login

Body:
```json
{
  "email": "usuario@email.com",
  "password": "123456"
}
Rota protegida:
GET /users/me

Header:
Authorization: Bearer <token>
Status
- Backend finalizado
- Pronto para integração com frontend
- Projeto de portfólio
