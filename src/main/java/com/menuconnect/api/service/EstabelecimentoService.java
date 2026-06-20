package com.menuconnect.api.service;

import com.menuconnect.api.model.Estabelecimento;
import com.menuconnect.api.repository.EstabelecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstabelecimentoService {

    @Autowired
    private EstabelecimentoRepository repository;

    // Método para criar um novo estabelecimento
    public Estabelecimento criarEstabelecimento(Estabelecimento estabelecimento) {
        // Futuramente, podemos adicionar regras de negócio aqui, 
        // como validar se o CNPJ é real ou se já existe no banco.
        return repository.save(estabelecimento);
    }

    // Método para listar todos
    public List<Estabelecimento> listarTodos() {
        return repository.findAll();
    }

    // Método para buscar um específico pelo ID
    public Estabelecimento buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Estabelecimento não encontrado!"));
    }
}