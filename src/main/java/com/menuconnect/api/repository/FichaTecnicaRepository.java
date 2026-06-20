package com.menuconnect.api.repository;

import com.menuconnect.api.model.FichaTecnica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FichaTecnicaRepository extends JpaRepository<FichaTecnica, Long> {
    // Usado pelo sistema para saber o que abater do estoque quando um prato for vendido
    List<FichaTecnica> findByProdutoId(Long produtoId);
}