package com.menuconnect.api.repository;

import com.menuconnect.api.model.Insumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Long> {
    List<Insumo> findByEstabelecimentoId(Long estabelecimentoId);
}