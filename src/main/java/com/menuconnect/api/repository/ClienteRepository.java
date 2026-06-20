package com.menuconnect.api.repository;

import com.menuconnect.api.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    // Busca o perfil completo do cliente através do ID de usuário da segurança
    Cliente findByUsuarioId(Long usuarioId);
}