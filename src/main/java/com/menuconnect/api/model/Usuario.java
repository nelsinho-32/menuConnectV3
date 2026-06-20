package com.menuconnect.api.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Data
@Entity
@Table(name = "usuarios")
public class Usuario implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String senha;

    // Ex: "GERENTE", "FUNCIONARIO", "CLIENTE"
    @Column(nullable = false)
    private String perfilAcesso;

    @Column(nullable = false)
    private Boolean ativo;

    // ====================================================================
    // MÉTODOS DO CONTRATO USERDETAILS (Obrigatórios para o Spring Security)
    // ====================================================================

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Diz ao Spring qual é o nível de permissão deste usuário
        return List.of(new SimpleGrantedAuthority("ROLE_" + this.perfilAcesso));
    }

    @Override
    public String getPassword() {
        return this.senha;
    }

    @Override
    public String getUsername() {
        return this.email; // No nosso sistema, o "username" é o e-mail
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return this.ativo;
    }
}