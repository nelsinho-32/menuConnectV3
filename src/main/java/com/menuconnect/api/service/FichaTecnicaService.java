package com.menuconnect.api.service;

import com.menuconnect.api.model.FichaTecnica;
import com.menuconnect.api.repository.FichaTecnicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaTecnicaService {

    @Autowired
    private FichaTecnicaRepository repository;

    public FichaTecnica adicionarIngredienteAoProduto(FichaTecnica fichaTecnica) {
        return repository.save(fichaTecnica);
    }

    public List<FichaTecnica> buscarReceitaDoProduto(Long produtoId) {
        return repository.findByProdutoId(produtoId);
    }
}