package br.org.postalis.training.rh.identidade.application;

import br.org.postalis.training.rh.identidade.domain.Usuario;
import org.springframework.stereotype.Service;

/**
 * Serviço de aplicação para casos de uso relacionados a Usuário.
 */
@Service
public class UsuarioService {

    public Usuario criarUsuario(String login, String email, String senha) {
        return new Usuario(login, email, senha);
    }

    public void desativarUsuario(Usuario usuario) {
        usuario.desativar();
    }

    public void ativarUsuario(Usuario usuario) {
        usuario.ativar();
    }

    public void alterarSenha(Usuario usuario, String novaSenha) {
        usuario.alterarSenha(novaSenha);
    }
}
