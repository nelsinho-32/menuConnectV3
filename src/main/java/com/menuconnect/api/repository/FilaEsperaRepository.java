package com.menuconnect.api.repository;

import com.menuconnect.api.model.FilaEspera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FilaEsperaRepository extends JpaRepository<FilaEspera, Long> {
    
    // Busca a fila de um estabelecimento específico, ordenando pela data/hora de entrada (quem chegou antes)
    List<FilaEspera> findByEstabelecimentoIdAndStatusOrderByDataHoraEntradaAsc(Long estabelecimentoId, String status);
}