package com.menuconnect.api.service;

import com.menuconnect.api.model.Produto;
import com.menuconnect.api.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public Produto salvarProduto(Produto produto) {
        // Regra de negócio: Um produto sempre precisa ter um estabelecimento vinculado
        if (produto.getEstabelecimento() == null || produto.getEstabelecimento().getId() == null) {
            throw new IllegalArgumentException("O produto deve pertencer a um estabelecimento válido.");
        }
        return repository.save(produto);
    }

    public List<Produto> listarPorEstabelecimento(Long estabelecimentoId) {
        return repository.findByEstabelecimentoId(estabelecimentoId);
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }
}