package com.menuconnect.api.service;

import com.menuconnect.api.model.Cupom;
import com.menuconnect.api.repository.CupomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CupomService {

    @Autowired
    private CupomRepository repository;

    public Cupom criarCupom(Cupom cupom) {
        cupom.setUsosAtuais(0);
        return repository.save(cupom);
    }

    public Cupom validarEAplicarCupom(String codigo, Long estabelecimentoId) {
        Cupom cupom = repository.findByCodigoAndEstabelecimentoId(codigo, estabelecimentoId)
                .orElseThrow(() -> new RuntimeException("Cupom inválido ou inexistente!"));

        if (cupom.getDataValidade() != null && cupom.getDataValidade().isBefore(LocalDateTime.now())) {
            throw new RuntimeException("Este cupom já expirou.");
        }

        if (cupom.getLimiteUsosGlobais() != null && cupom.getUsosAtuais() >= cupom.getLimiteUsosGlobais()) {
            throw new RuntimeException("Este cupom atingiu o limite máximo de utilizações.");
        }

        // Incrementa o uso do cupom e salva
        cupom.setUsosAtuais(cupom.getUsosAtuais() + 1);
        return repository.save(cupom);
    }
}