package com.menuconnect.api.repository;

import com.menuconnect.api.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    // Lista todos os pagamentos (ex: parte no Pix, parte no cartão) de uma comanda específica
    List<Pagamento> findByComandaId(Long comandaId);
}