package br.org.postalis.training.rh.rh.api;

import br.org.postalis.training.rh.rh.application.ColaboradorService;
import br.org.postalis.training.rh.rh.domain.Colaborador;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * Controller REST para operações de Colaborador.
 */
@RestController
@RequestMapping("/api/colaboradores")
@RequiredArgsConstructor
public class ColaboradorController {

    private final ColaboradorService colaboradorService;

    @PostMapping
    public ResponseEntity<ColaboradorResponse> admitir(@RequestBody AdmitirColaboradorRequest request) {
        Colaborador colaborador = colaboradorService.admitirColaborador(
            request.nome(),
            request.cpf(),
            request.email(),
            request.dataAdmissao(),
            request.cargoId(),
            request.departamentoId()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(toResponse(colaborador));
    }

    @PutMapping("/{id}/desligar")
    public ResponseEntity<Void> desligar(@PathVariable UUID id, @RequestBody DesligarRequest request) {
        colaboradorService.desligarColaborador(id, request.dataDesligamento());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/transferir")
    public ResponseEntity<Void> transferir(@PathVariable UUID id, @RequestBody TransferirRequest request) {
        colaboradorService.transferirColaborador(id, request.novoDepartamentoId());
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/promover")
    public ResponseEntity<Void> promover(@PathVariable UUID id, @RequestBody PromoverRequest request) {
        colaboradorService.promoverColaborador(id, request.novoCargoId());
        return ResponseEntity.noContent().build();
    }

    private ColaboradorResponse toResponse(Colaborador colaborador) {
        return new ColaboradorResponse(
            colaborador.getId(),
            colaborador.getNome(),
            colaborador.getCpf(),
            colaborador.getEmail(),
            colaborador.getDataAdmissao(),
            colaborador.getStatus().name()
        );
    }

    public record AdmitirColaboradorRequest(
        String nome, 
        String cpf, 
        String email, 
        LocalDate dataAdmissao, 
        UUID cargoId, 
        UUID departamentoId
    ) {}

    public record DesligarRequest(LocalDate dataDesligamento) {}

    public record TransferirRequest(UUID novoDepartamentoId) {}

    public record PromoverRequest(UUID novoCargoId) {}

    public record ColaboradorResponse(
        UUID id, 
        String nome, 
        String cpf, 
        String email, 
        LocalDate dataAdmissao, 
        String status
    ) {}
}
