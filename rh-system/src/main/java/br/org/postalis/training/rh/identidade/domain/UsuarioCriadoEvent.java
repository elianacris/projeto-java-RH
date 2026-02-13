package br.org.postalis.training.rh.identidade.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class UsuarioCriadoEvent extends DomainEvent {

    private final UUID usuarioId;
    private final String login;
    private final String email;

    public UsuarioCriadoEvent(UUID usuarioId, String login, String email) {
        super();
        this.usuarioId = usuarioId;
        this.login = login;
        this.email = email;
    }
}
