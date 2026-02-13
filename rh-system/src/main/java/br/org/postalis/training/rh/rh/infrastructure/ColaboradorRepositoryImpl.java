package br.org.postalis.training.rh.rh.infrastructure;

import br.org.postalis.training.rh.rh.domain.Colaborador;
import br.org.postalis.training.rh.rh.domain.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

/**
 * Implementação do repositório de domínio usando Spring Data JPA.
 */
@Repository
@RequiredArgsConstructor
public class ColaboradorRepositoryImpl implements ColaboradorRepository {

    private final ColaboradorJpaRepository jpaRepository;

    @Override
    public Colaborador save(Colaborador colaborador) {
        return jpaRepository.save(colaborador);
    }

    @Override
    public Optional<Colaborador> findById(UUID id) {
        return jpaRepository.findById(id);
    }

    @Override
    public Optional<Colaborador> findByCpf(String cpf) {
        return jpaRepository.findByCpf(cpf);
    }

    @Override
    public void delete(Colaborador colaborador) {
        jpaRepository.delete(colaborador);
    }
}
