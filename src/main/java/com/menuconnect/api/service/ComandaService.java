package com.menuconnect.api.service;

import com.menuconnect.api.model.Comanda;
import com.menuconnect.api.repository.ComandaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ComandaService {

    @Autowired
    private ComandaRepository repository;

    public Comanda abrirComanda(Comanda comanda) {
        comanda.setDataHoraAbertura(LocalDateTime.now());
        comanda.setStatus("ABERTA");
        return repository.save(comanda);
    }

    public Comanda fecharComanda(Long id) {
        Comanda comanda = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Comanda não encontrada!"));
        
        comanda.setDataHoraFechamento(LocalDateTime.now());
        comanda.setStatus("AGUARDANDO_PAGAMENTO");
        return repository.save(comanda);
    }

    public List<Comanda> listarComandasAtivas(Long estabelecimentoId) {
        return repository.findByEstabelecimentoIdAndStatus(estabelecimentoId, "ABERTA");
    }
}