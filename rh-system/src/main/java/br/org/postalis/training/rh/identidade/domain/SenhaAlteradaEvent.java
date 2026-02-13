package br.org.postalis.training.rh.identidade.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class SenhaAlteradaEvent extends DomainEvent {

    private final UUID usuarioId;

    public SenhaAlteradaEvent(UUID usuarioId) {
        super();
        this.usuarioId = usuarioId;
    }
}
