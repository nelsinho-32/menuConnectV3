package com.menuconnect.api.service;

import com.menuconnect.api.model.FilaEspera;
import com.menuconnect.api.repository.FilaEsperaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class FilaEsperaService {

    @Autowired
    private FilaEsperaRepository repository;

    public FilaEspera adicionarAFila(FilaEspera fila) {
        fila.setDataHoraEntrada(LocalDateTime.now());
        fila.setStatus("AGUARDANDO");
        return repository.save(fila);
    }

    public FilaEspera notificarCliente(Long id) {
        FilaEspera fila = repository.findById(id).orElseThrow();
        fila.setStatus("NOTIFICADO");
        // Futuramente, aqui chamaremos o n8n via Webhook para disparar o WhatsApp!
        return repository.save(fila);
    }
}