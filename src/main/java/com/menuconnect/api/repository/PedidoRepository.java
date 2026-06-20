package com.menuconnect.api.repository;

import com.menuconnect.api.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    // Alimenta o painel da cozinha buscando todos os pedidos que não foram entregues
    List<Pedido> findByComandaEstabelecimentoIdAndStatusCozinha(Long estabelecimentoId, String statusCozinha);
    
    List<Pedido> findByComandaId(Long comandaId);
}