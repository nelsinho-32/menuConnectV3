package com.menuconnect.api.service;

import com.menuconnect.api.model.Avaliacao;
import com.menuconnect.api.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public Avaliacao registrarAvaliacao(Avaliacao avaliacao) {
        if (avaliacao.getNota() < 1 || avaliacao.getNota() > 5) {
            throw new IllegalArgumentException("A nota deve ser entre 1 e 5 estrelas.");
        }
        
        avaliacao.setDataHoraAvaliacao(LocalDateTime.now());
        return repository.save(avaliacao);
    }

    public List<Avaliacao> listarAvaliacoesDoLocal(Long estabelecimentoId) {
        return repository.findByEstabelecimentoIdOrderByDataHoraAvaliacaoDesc(estabelecimentoId);
    }
}