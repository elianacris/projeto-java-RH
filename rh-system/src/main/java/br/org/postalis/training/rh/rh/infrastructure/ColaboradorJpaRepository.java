package br.org.postalis.training.rh.rh.infrastructure;

import br.org.postalis.training.rh.rh.domain.Colaborador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * Repositório JPA para Colaborador.
 */
public interface ColaboradorJpaRepository extends JpaRepository<Colaborador, UUID> {

    Optional<Colaborador> findByCpf(String cpf);
}
