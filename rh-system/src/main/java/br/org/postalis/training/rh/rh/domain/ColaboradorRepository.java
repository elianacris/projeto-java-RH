package br.org.postalis.training.rh.rh.domain;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositório de domínio para Colaborador.
 */
public interface ColaboradorRepository {

    Colaborador save(Colaborador colaborador);

    Optional<Colaborador> findById(UUID id);

    Optional<Colaborador> findByCpf(String cpf);

    void delete(Colaborador colaborador);
}
