package com.menuconnect.api.service;

import com.menuconnect.api.model.Entrega;
import com.menuconnect.api.repository.EntregaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class EntregaService {

    @Autowired
    private EntregaRepository repository;

    public Entrega registrarNovaEntrega(Entrega entrega) {
        entrega.setStatus("AGUARDANDO_MOTOBOY");
        return repository.save(entrega);
    }

    public Entrega despacharComMotoboy(Long entregaId, Long funcionarioId) {
        Entrega entrega = repository.findById(entregaId)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada!"));
        
        // Aqui faltaria apenas buscar o Funcionario pelo ID e setar na entrega
        entrega.setStatus("A_CAMINHO");
        entrega.setDataHoraSaida(LocalDateTime.now());
        
        return repository.save(entrega);
    }
    
    public Entrega confirmarEntrega(Long entregaId) {
        Entrega entrega = repository.findById(entregaId)
                .orElseThrow(() -> new RuntimeException("Entrega não encontrada!"));
                
        entrega.setStatus("ENTREGUE");
        entrega.setDataHoraEntrega(LocalDateTime.now());
        
        return repository.save(entrega);
    }
}