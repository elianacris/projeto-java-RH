package br.org.postalis.training.rh.rh.domain;

import br.org.postalis.training.rh.shared.domain.AggregateRoot;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Agregado de Colaborador no contexto de RH.
 */
@Entity
@Table(name = "colaboradores")
@Getter
public class Colaborador extends AggregateRoot {

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true, length = 11)
    private String cpf;

    @Column(nullable = false)
    private String email;

    @Column(name = "data_admissao", nullable = false)
    private LocalDate dataAdmissao;

    @Column(name = "cargo_id", nullable = false)
    private UUID cargoId;

    @Column(name = "departamento_id", nullable = false)
    private UUID departamentoId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusColaborador status;

    protected Colaborador() {
        super();
    }

    public Colaborador(String nome, String cpf, String email, LocalDate dataAdmissao, 
                       UUID cargoId, UUID departamentoId) {
        super();
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.dataAdmissao = dataAdmissao;
        this.cargoId = cargoId;
        this.departamentoId = departamentoId;
        this.status = StatusColaborador.ATIVO;
        registerEvent(new ColaboradorAdmitidoEvent(this.getId(), nome, cpf, dataAdmissao));
    }

    public void desligar(LocalDate dataDesligamento) {
        this.status = StatusColaborador.DESLIGADO;
        registerEvent(new ColaboradorDesligadoEvent(this.getId(), dataDesligamento));
    }

    public void transferirDepartamento(UUID novoDepartamentoId) {
        UUID departamentoAnterior = this.departamentoId;
        this.departamentoId = novoDepartamentoId;
        registerEvent(new ColaboradorTransferidoEvent(this.getId(), departamentoAnterior, novoDepartamentoId));
    }

    public void promover(UUID novoCargoId) {
        UUID cargoAnterior = this.cargoId;
        this.cargoId = novoCargoId;
        registerEvent(new ColaboradorPromovidoEvent(this.getId(), cargoAnterior, novoCargoId));
    }
}
