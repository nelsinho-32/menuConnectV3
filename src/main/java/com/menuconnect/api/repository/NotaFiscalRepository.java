package com.menuconnect.api.repository;

import com.menuconnect.api.model.NotaFiscal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface NotaFiscalRepository extends JpaRepository<NotaFiscal, Long> {
    // Encontra a nota fiscal vinculada a uma comanda exata
    Optional<NotaFiscal> findByComandaId(Long comandaId);
}