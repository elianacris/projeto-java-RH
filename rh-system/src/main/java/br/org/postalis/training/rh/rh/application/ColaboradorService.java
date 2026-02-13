package br.org.postalis.training.rh.rh.application;

import br.org.postalis.training.rh.rh.domain.Colaborador;
import br.org.postalis.training.rh.rh.domain.ColaboradorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Serviço de aplicação para casos de uso relacionados a Colaborador.
 */
@Service
@RequiredArgsConstructor
@Transactional
public class ColaboradorService {

    private final ColaboradorRepository colaboradorRepository;

    public Colaborador admitirColaborador(String nome, String cpf, String email, 
                                          LocalDate dataAdmissao, UUID cargoId, UUID departamentoId) {
        Colaborador colaborador = new Colaborador(nome, cpf, email, dataAdmissao, cargoId, departamentoId);
        return colaboradorRepository.save(colaborador);
    }

    public void desligarColaborador(UUID colaboradorId, LocalDate dataDesligamento) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
            .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));
        colaborador.desligar(dataDesligamento);
        colaboradorRepository.save(colaborador);
    }

    public void transferirColaborador(UUID colaboradorId, UUID novoDepartamentoId) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
            .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));
        colaborador.transferirDepartamento(novoDepartamentoId);
        colaboradorRepository.save(colaborador);
    }

    public void promoverColaborador(UUID colaboradorId, UUID novoCargoId) {
        Colaborador colaborador = colaboradorRepository.findById(colaboradorId)
            .orElseThrow(() -> new IllegalArgumentException("Colaborador não encontrado"));
        colaborador.promover(novoCargoId);
        colaboradorRepository.save(colaborador);
    }
}
