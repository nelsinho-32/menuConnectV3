package com.menuconnect.api.service;

import com.menuconnect.api.model.NotaFiscal;
import com.menuconnect.api.repository.NotaFiscalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotaFiscalService {

    @Autowired
    private NotaFiscalRepository repository;

    public NotaFiscal solicitarEmissao(NotaFiscal nota) {
        nota.setDataHoraEmissao(LocalDateTime.now());
        nota.setStatusSefaz("PROCESSANDO");
        
        //  Aqui entrará a biblioteca de integração com o WebService da Sefaz (geração do XML e assinatura digital).
        // Após a Sefaz retornar o OK:
        // nota.setChaveAcessoSefaz("00000000000000000000000000000000000000000000");
        // nota.setStatusSefaz("EMITIDA");

        return repository.save(nota);
    }
}