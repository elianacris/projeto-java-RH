-- Tabela de eventos (Event Store)
CREATE TABLE IF NOT EXISTS domain_events (
    event_id UUID PRIMARY KEY,
    aggregate_id UUID NOT NULL,
    aggregate_type VARCHAR(255) NOT NULL,
    event_type VARCHAR(255) NOT NULL,
    event_version INT NOT NULL DEFAULT 1,
    sequence_number BIGINT NOT NULL,

    payload JSONB NOT NULL,
    metadata JSONB,

    occurred_on TIMESTAMPTZ NOT NULL,
    persisted_on TIMESTAMPTZ DEFAULT NOW() NOT NULL,

    CONSTRAINT uk_aggregate_sequence UNIQUE(aggregate_id, sequence_number)
);

-- Índice para busca por aggregate
CREATE INDEX idx_domain_events_aggregate
    ON domain_events(aggregate_id, sequence_number ASC);

-- Índice para busca por tipo de evento
CREATE INDEX idx_domain_events_type
    ON domain_events(event_type, occurred_on DESC);

-- Comentários
COMMENT ON TABLE domain_events IS 'Event Store - Fonte da verdade (imutável)';
COMMENT ON COLUMN domain_events.sequence_number IS 'Número sequencial para ordenação e optimistic locking';
COMMENT ON COLUMN domain_events.payload IS 'Evento serializado em JSON';
