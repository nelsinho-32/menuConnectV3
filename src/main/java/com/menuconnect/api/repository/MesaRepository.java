package com.menuconnect.api.repository;

import com.menuconnect.api.model.Mesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    // Útil para o mapa do salão mostrar apenas mesas livres
    List<Mesa> findByEstabelecimentoIdAndStatus(Long estabelecimentoId, String status);
}