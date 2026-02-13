package br.org.postalis.training.rh.rh.domain;

import br.org.postalis.training.rh.shared.domain.DomainEvent;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
public class ColaboradorAdmitidoEvent extends DomainEvent {

    private final UUID colaboradorId;
    private final String nome;
    private final String cpf;
    private final LocalDate dataAdmissao;

    public ColaboradorAdmitidoEvent(UUID colaboradorId, String nome, String cpf, LocalDate dataAdmissao) {
        super();
        this.colaboradorId = colaboradorId;
        this.nome = nome;
        this.cpf = cpf;
        this.dataAdmissao = dataAdmissao;
    }
}
