package br.org.postalis.training.rh.shared.domain;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Transient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

/**
 * Classe base para agregados (Aggregate Roots).
 * Um agregado é um cluster de objetos de domínio que podem ser tratados como uma única unidade.
 * O Aggregate Root é a única entidade do agregado que entidades externas podem referenciar.
 */
@MappedSuperclass
public abstract class AggregateRoot extends Entity {

    @Transient
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    protected AggregateRoot(UUID id) {
        super(id);
    }

    protected AggregateRoot() {
        super();
    }

    protected void registerEvent(DomainEvent event) {
        this.domainEvents.add(event);
    }

    public List<DomainEvent> getDomainEvents() {
        return Collections.unmodifiableList(domainEvents);
    }

    public void clearDomainEvents() {
        this.domainEvents.clear();
    }
}
