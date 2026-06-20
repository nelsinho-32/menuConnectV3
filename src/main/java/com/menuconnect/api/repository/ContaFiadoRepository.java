package com.menuconnect.api.repository;

import com.menuconnect.api.model.ContaFiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContaFiadoRepository extends JpaRepository<ContaFiado, Long> {
    ContaFiado findByEstabelecimentoIdAndClienteId(Long estabelecimentoId, Long clienteId);
}