package com.menuconnect.api.repository;

import com.menuconnect.api.model.LancamentoFiado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface LancamentoFiadoRepository extends JpaRepository<LancamentoFiado, Long> {
    // Busca todo o histórico de dívidas e pagamentos de uma conta fiado
    List<LancamentoFiado> findByContaFiadoIdOrderByDataHoraLancamentoDesc(Long contaFiadoId);
}