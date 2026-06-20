package com.menuconnect.api.repository;

import com.menuconnect.api.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    // O Spring lê o nome desse método e cria o "SELECT * FROM produtos WHERE estabelecimento_id = ?" sozinho!
    List<Produto> findByEstabelecimentoId(Long estabelecimentoId);
    
    // Busca produtos por categoria dentro de um estabelecimento específico
    List<Produto> findByEstabelecimentoIdAndCategoria(Long estabelecimentoId, String categoria);
}