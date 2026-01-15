# auth-service

API de autenticação com Spring Boot, JWT e Postgres.

## Integração com o portifolio-site

- Base URL (local): `http://localhost:8080`
- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Health check: `http://localhost:8080/actuator/health`

### Fluxo

1) Criar usuário

`POST /users`

2) Login

`POST /auth/login` → retorna `{ "token": "..." }`

3) Consumir endpoints protegidos

Enviar header: `Authorization: Bearer <token>`

### CORS

Configure as origens permitidas via variável:

- `CORS_ALLOWED_ORIGINS=http://localhost:3000,http://localhost:5173,https://seu-dominio.com`

## Rodando com Docker

Na pasta `auth-service/`:

- `docker compose up --build`

Variáveis úteis:

- `JWT_SECRET` (recomendado definir em produção)
- `JWT_EXPIRATION_MINUTES` (default 60)
- `CORS_ALLOWED_ORIGINS`

# Projeto em construção 

Este repositório faz parte do meu portfólio backend desenvolvido em Java Spring Boot.

Documentação completa será adicionada conforme o projeto evoluir.
