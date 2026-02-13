package br.org.postalis.training.rh.rh.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.util.UUID;

@Getter
public class ColaboradorPromovidoEvent extends DomainEvent {

    private final UUID colaboradorId;
    private final UUID cargoAnterior;
    private final UUID novoCargo;

    public ColaboradorPromovidoEvent(UUID colaboradorId, UUID cargoAnterior, UUID novoCargo) {
        super();
        this.colaboradorId = colaboradorId;
        this.cargoAnterior = cargoAnterior;
        this.novoCargo = novoCargo;
    }
}
