package br.org.postalis.training.rh.identidade.domain;

import br.org.postalis.training.rh.shared.domain.AggregateRoot;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;

/**
 * Agregado de Usuário no contexto de Identidade.
 */
@Entity
@Table(name = "usuarios")
@Getter
public class Usuario extends AggregateRoot {

    @Column(nullable = false, unique = true, length = 100)
    private String login;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    @Column(nullable = false)
    private boolean ativo;

    protected Usuario() {
        super();
    }

    public Usuario(String login, String email, String senha) {
        super();
        this.login = login;
        this.email = email;
        this.senha = senha;
        this.ativo = true;
        registerEvent(new UsuarioCriadoEvent(this.getId(), login, email));
    }

    public void desativar() {
        this.ativo = false;
        registerEvent(new UsuarioDesativadoEvent(this.getId()));
    }

    public void ativar() {
        this.ativo = true;
        registerEvent(new UsuarioAtivadoEvent(this.getId()));
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
        registerEvent(new SenhaAlteradaEvent(this.getId()));
    }
}
