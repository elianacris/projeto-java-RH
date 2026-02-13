package br.org.postalis.training.rh.rh.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ColaboradorTransferidoEvent extends DomainEvent {

    private final UUID colaboradorId;
    private final UUID departamentoAnterior;
    private final UUID novoDepartamento;

    public ColaboradorTransferidoEvent(UUID colaboradorId, UUID departamentoAnterior, UUID novoDepartamento) {
        super();
        this.colaboradorId = colaboradorId;
        this.departamentoAnterior = departamentoAnterior;
        this.novoDepartamento = novoDepartamento;
    }
}
