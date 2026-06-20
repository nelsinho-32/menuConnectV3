package com.menuconnect.api.repository;

import com.menuconnect.api.model.Comanda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ComandaRepository extends JpaRepository<Comanda, Long> {
    
    // Ideal para o painel do caixa ver apenas as comandas que estão rolando agora
    List<Comanda> findByEstabelecimentoIdAndStatus(Long estabelecimentoId, String status);
}