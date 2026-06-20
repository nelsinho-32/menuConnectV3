package com.menuconnect.api.repository;

import com.menuconnect.api.model.RegistroPerda;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface RegistroPerdaRepository extends JpaRepository<RegistroPerda, Long> {
    
    // Busca todo o histórico de perdas e desperdícios de um estabelecimento
    List<RegistroPerda> findByEstabelecimentoIdOrderByDataHoraRegistroDesc(Long estabelecimentoId);
}