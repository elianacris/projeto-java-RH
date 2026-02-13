# Docker Infrastructure - RH System

## 📦 Serviços Disponíveis

| Serviço       | Container      | Porta       | Credenciais                        |
|---------------|----------------|-------------|------------------------------------|
| PostgreSQL 18 | rh-postgres    | 5432        | dev / dev123 (db: rh_training)    |
| Redis 7       | rh-redis       | 6379        | -                                  |
| Azurite       | rh-azurite     | 10000-10002 | -                                  |
| SQL Server    | rh-sqlserver   | 1433        | sa / ServiceBus123!                |
| Service Bus   | rh-servicebus  | 5672        | -                                  |

## 🚀 Iniciar Infraestrutura

```bash
# Subir todos os serviços
docker compose up -d

# Ver logs
docker compose logs -f

# Ver status
docker compose ps
```

## ✅ Verificar Serviços

### PostgreSQL
```bash
# Conectar ao banco
docker exec -it rh-postgres psql -U dev -d rh_training

# Listar schemas
\dn

# Sair
\q
```

### Redis
```bash
# Testar conexão
docker exec -it rh-redis redis-cli PING
# Deve retornar: PONG
```

### Azurite (Azure Storage Emulator)
- Blob: http://localhost:10000
- Queue: http://localhost:10001
- Table: http://localhost:10002

## 🛑 Parar Infraestrutura

```bash
# Parar todos os serviços
docker compose down

# Parar e remover volumes (limpar dados)
docker compose down -v
```

## 📊 Schemas do PostgreSQL

O banco de dados possui 3 schemas:

- **`rh`** - Módulo de Recursos Humanos
- **`identidade`** - Módulo de Identidade e Autenticação
- **`shared`** - Módulo Compartilhado

## 🔧 Troubleshooting

### Container não inicia
```bash
# Ver logs detalhados
docker compose logs <nome-do-servico>

# Exemplo:
docker compose logs postgres
```

### Recriar um container específico
```bash
docker compose rm -f postgres
docker compose up -d postgres
```

### Porta já em uso
```bash
# Ver o que está usando a porta (macOS/Linux)
lsof -i :5432

# Matar o processo
kill -9 <PID>
```

## 📝 Configuração do Service Bus

O Service Bus Emulator está configurado com:
- **Namespace**: sbemulator
- **Queues**: rh-events, identidade-events
- **Topics**: domain-events
  - **Subscriptions**: rh-subscription, identidade-subscription

Veja a configuração completa em: `docker/servicebus-config.json`
