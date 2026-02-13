-- Migration: Criar tabelas de domínio (usuarios e colaboradores)

-- Tabela: usuarios (módulo identidade)
CREATE TABLE IF NOT EXISTS rh.usuarios (
    id UUID PRIMARY KEY,
    login VARCHAR(100) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    ativo BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_usuarios_login ON rh.usuarios(login);
CREATE INDEX idx_usuarios_email ON rh.usuarios(email);

-- Tabela: colaboradores (módulo rh)
CREATE TABLE IF NOT EXISTS rh.colaboradores (
    id UUID PRIMARY KEY,
    nome VARCHAR(255) NOT NULL,
    cpf VARCHAR(11) NOT NULL UNIQUE,
    email VARCHAR(255) NOT NULL,
    data_admissao DATE NOT NULL,
    cargo_id UUID NOT NULL,
    departamento_id UUID NOT NULL,
    status VARCHAR(20) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_colaboradores_cpf ON rh.colaboradores(cpf);
CREATE INDEX idx_colaboradores_email ON rh.colaboradores(email);
CREATE INDEX idx_colaboradores_status ON rh.colaboradores(status);
CREATE INDEX idx_colaboradores_departamento ON rh.colaboradores(departamento_id);
CREATE INDEX idx_colaboradores_cargo ON rh.colaboradores(cargo_id);

-- Comentários das tabelas
COMMENT ON TABLE rh.usuarios IS 'Tabela de usuários do sistema - Módulo Identidade';
COMMENT ON TABLE rh.colaboradores IS 'Tabela de colaboradores da empresa - Módulo RH';

-- Comentários das colunas principais
COMMENT ON COLUMN rh.colaboradores.status IS 'Status do colaborador: ATIVO, AFASTADO, FERIAS, DESLIGADO';
