package com.menuconnect.api.service;

import com.menuconnect.api.model.Pedido;
import com.menuconnect.api.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository repository;

    public Pedido criarPedido(Pedido pedido) {
        pedido.setDataHoraPedido(LocalDateTime.now());
        pedido.setStatusCozinha("NA_FILA"); // Entra direto na fila do KDS
        return repository.save(pedido);
    }

    public Pedido atualizarStatusCozinha(Long id, String novoStatus) {
        Pedido pedido = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido não encontrado!"));
        
        pedido.setStatusCozinha(novoStatus); // Ex: muda para "EM_PREPARO" ou "PRONTO"
        return repository.save(pedido);
    }

    public List<Pedido> listarPedidosPendentes(Long estabelecimentoId) {
        return repository.findByComandaEstabelecimentoIdAndStatusCozinha(estabelecimentoId, "NA_FILA");
    }
}