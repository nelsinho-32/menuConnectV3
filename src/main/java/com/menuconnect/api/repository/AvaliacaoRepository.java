package com.menuconnect.api.repository;

import com.menuconnect.api.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    // Lista todas as avaliações que um estabelecimento recebeu
    List<Avaliacao> findByEstabelecimentoIdOrderByDataHoraAvaliacaoDesc(Long estabelecimentoId);
    
    // Lista todas as avaliações feitas por um cliente específico
    List<Avaliacao> findByClienteId(Long clienteId);
}