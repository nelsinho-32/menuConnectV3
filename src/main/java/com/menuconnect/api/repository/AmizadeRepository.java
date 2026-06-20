package com.menuconnect.api.repository;

import com.menuconnect.api.model.Amizade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AmizadeRepository extends JpaRepository<Amizade, Long> {
    // Lista os amigos de um cliente com base no status (ex: "ACEITO")
    List<Amizade> findByClienteIdAndStatus(Long clienteId, String status);
}