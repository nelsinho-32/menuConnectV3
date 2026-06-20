package com.menuconnect.api.repository;

import com.menuconnect.api.model.Entrega;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;
import java.util.List;

@Repository
public interface EntregaRepository extends JpaRepository<Entrega, Long> {
    
    // Busca a entrega vinculada a uma comanda específica
    Optional<Entrega> findByComandaId(Long comandaId);

    // Opcional: Lista as entregas que um motoboy específico fez
    List<Entrega> findByEntregadorId(Long entregadorId);
}