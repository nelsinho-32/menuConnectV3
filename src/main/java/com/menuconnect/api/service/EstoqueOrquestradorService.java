package com.menuconnect.api.service;

import com.menuconnect.api.model.FichaTecnica;
import com.menuconnect.api.model.Insumo;
import com.menuconnect.api.model.ItemPedido;
import com.menuconnect.api.repository.FichaTecnicaRepository;
import com.menuconnect.api.repository.InsumoRepository;
import com.menuconnect.api.repository.ItemPedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class EstoqueOrquestradorService {

    @Autowired
    private ItemPedidoRepository itemPedidoRepository;

    @Autowired
    private FichaTecnicaRepository fichaTecnicaRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    // A anotação @Transactional garante que se der erro no meio (ex: banco cair), 
    // ele desfaz tudo e não deixa o estoque furado.
    @Transactional
    public void debitarEstoqueDoPedido(Long pedidoId) {
        // 1. Pega todos os itens que o cliente pediu (ex: 2 hambúrgueres)
        List<ItemPedido> itens = itemPedidoRepository.findByPedidoId(pedidoId);

        for (ItemPedido item : itens) {
            // 2. Busca a receita daquele produto específico
            List<FichaTecnica> receita = fichaTecnicaRepository.findByProdutoId(item.getProduto().getId());

            for (FichaTecnica ingrediente : receita) {
                Insumo insumo = ingrediente.getInsumo();
                
                // 3. Calcula: (Quantidade gasta na receita) x (Quantidade de pratos pedidos)
                BigDecimal quantidadeTotalGasta = ingrediente.getQuantidadeNecessaria()
                        .multiply(new BigDecimal(item.getQuantidade()));

                // 4. Subtrai do estoque atual e salva
                insumo.setQuantidadeAtual(insumo.getQuantidadeAtual().subtract(quantidadeTotalGasta));
                insumoRepository.save(insumo);
            }
        }
    }
}