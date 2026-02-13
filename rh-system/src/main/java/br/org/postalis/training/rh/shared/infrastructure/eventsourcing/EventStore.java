package br.org.postalis.training.rh.shared.infrastructure.eventsourcing;

import br.org.postalis.training.rh.shared.domain.DomainEvent;

import java.util.List;
import java.util.UUID;

/**
 * Interface para armazenamento de eventos (Event Store).
 * Responsável por persistir e recuperar eventos de domínio.
 */
public interface EventStore {

    void save(DomainEvent event);

    void saveAll(List<DomainEvent> events);

    List<DomainEvent> findByAggregateId(UUID aggregateId);

    List<DomainEvent> findAll();
}
