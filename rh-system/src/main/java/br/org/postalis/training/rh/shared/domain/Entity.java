package br.org.postalis.training.rh.shared.domain;

import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

import java.util.Objects;
import java.util.UUID;

/**
 * Classe base para entidades do domínio.
 * Uma entidade é identificada por um ID único e possui continuidade ao longo do tempo.
 */
@MappedSuperclass
public abstract class Entity {

    @Id
    private UUID id;

    protected Entity(UUID id) {
        this.id = Objects.requireNonNull(id, "ID não pode ser nulo");
    }

    protected Entity() {
        this.id = UUID.randomUUID();
    }

    public UUID getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entity entity = (Entity) o;
        return Objects.equals(id, entity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
