package br.org.postalis.training.rh.rh.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ColaboradorDesligadoEvent extends DomainEvent {

    private final UUID colaboradorId;
    private final LocalDate dataDesligamento;

    public ColaboradorDesligadoEvent(UUID colaboradorId, LocalDate dataDesligamento) {
        super();
        this.colaboradorId = colaboradorId;
        this.dataDesligamento = dataDesligamento;
    }
}
