package com.menuconnect.api.service;

import com.menuconnect.api.model.Insumo;
import com.menuconnect.api.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InsumoService {

    @Autowired
    private InsumoRepository repository;

    public Insumo cadastrarInsumo(Insumo insumo) {
        return repository.save(insumo);
    }

    public List<Insumo> listarPorEstabelecimento(Long estabelecimentoId) {
        return repository.findByEstabelecimentoId(estabelecimentoId);
    }
    
    // Método para o administrador ajustar o estoque manualmente, se necessário
    public Insumo atualizarQuantidade(Long id, java.math.BigDecimal novaQuantidade) {
        Insumo insumo = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Insumo não encontrado!"));
        insumo.setQuantidadeAtual(novaQuantidade);
        return repository.save(insumo);
    }
}