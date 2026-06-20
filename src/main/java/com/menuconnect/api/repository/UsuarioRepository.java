package com.menuconnect.api.repository;

import com.menuconnect.api.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Essencial para o Spring Security encontrar o usuário na hora do login
    Optional<Usuario> findByEmail(String email);
}