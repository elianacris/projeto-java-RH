package br.org.postalis.training.rh.identidade.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UsuarioAtivadoEvent extends DomainEvent {

    private final UUID usuarioId;

    public UsuarioAtivadoEvent(UUID usuarioId) {
        super();
        this.usuarioId = usuarioId;
    }
}
