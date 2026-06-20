package com.menuconnect.api.service;

import com.menuconnect.api.model.RegistroPerda;
import com.menuconnect.api.model.Insumo;
import com.menuconnect.api.repository.RegistroPerdaRepository;
import com.menuconnect.api.repository.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RegistroPerdaService {

    @Autowired
    private RegistroPerdaRepository perdaRepository;

    @Autowired
    private InsumoRepository insumoRepository;

    @Transactional
    public RegistroPerda registrarPerda(RegistroPerda perda) {
        perda.setDataHoraRegistro(LocalDateTime.now());
        
        // Além de registrar o prejuízo, precisamos abater o item do estoque físico
        Insumo insumo = insumoRepository.findById(perda.getInsumo().getId()).orElseThrow();
        insumo.setQuantidadeAtual(insumo.getQuantidadeAtual().subtract(perda.getQuantidadePerdida()));
        insumoRepository.save(insumo);

        return perdaRepository.save(perda);
    }
}