package br.org.postalis.training.rh.shared.domain;

import java.time.Instant;
import java.util.UUID;

/**
 * Classe base para eventos de domínio.
 * Um evento de domínio representa algo que aconteceu no domínio e é relevante para o negócio.
 */
public abstract class DomainEvent {

    private final UUID eventId;
    private final Instant occurredOn;

    protected DomainEvent() {
        this.eventId = UUID.randomUUID();
        this.occurredOn = Instant.now();
    }

    public UUID getEventId() {
        return eventId;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }
}
