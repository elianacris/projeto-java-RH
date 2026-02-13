package br.org.postalis.training.rh.identidade.api;

import br.org.postalis.training.rh.identidade.application.UsuarioService;
import br.org.postalis.training.rh.identidade.domain.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller REST para operações de Usuário.
 */
@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<UsuarioResponse> criarUsuario(@RequestBody CriarUsuarioRequest request) {
        Usuario usuario = usuarioService.criarUsuario(
            request.login(),
            request.email(),
            request.senha()
        );
        return ResponseEntity.status(HttpStatus.CREATED)
            .body(new UsuarioResponse(usuario.getId(), usuario.getLogin(), usuario.getEmail(), usuario.isAtivo()));
    }

    public record CriarUsuarioRequest(String login, String email, String senha) {}

    public record UsuarioResponse(UUID id, String login, String email, boolean ativo) {}
}
