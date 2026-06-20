package com.menuconnect.api.repository;

import com.menuconnect.api.model.EncontroParticipante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EncontroParticipanteRepository extends JpaRepository<EncontroParticipante, Long> {
    // Lista todos os convidados de um evento específico
    List<EncontroParticipante> findByEncontroId(Long encontroId);
    
    // Busca os convites pendentes ou confirmados de um cliente no app
    List<EncontroParticipante> findByClienteIdAndStatusPresenca(Long clienteId, String statusPresenca);
}