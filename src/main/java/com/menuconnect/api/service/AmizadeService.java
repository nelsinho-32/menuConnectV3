package com.menuconnect.api.service;

import com.menuconnect.api.model.Amizade;
import com.menuconnect.api.model.Cliente;
import com.menuconnect.api.repository.AmizadeRepository;
import com.menuconnect.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AmizadeService {

    @Autowired
    private AmizadeRepository amizadeRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    // Envia o convite
    public Amizade solicitarAmizade(Long clienteId, Long amigoId) {
        Cliente cliente = clienteRepository.findById(clienteId).orElseThrow();
        Cliente amigo = clienteRepository.findById(amigoId).orElseThrow();

        Amizade amizade = new Amizade();
        amizade.setCliente(cliente);
        amizade.setAmigo(amigo);
        amizade.setStatus("PENDENTE");
        amizade.setDataHoraConexao(LocalDateTime.now());

        return amizadeRepository.save(amizade);
    }

    // O amigo aceita ou recusa
    public Amizade responderSolicitacao(Long amizadeId, String resposta) {
        Amizade amizade = amizadeRepository.findById(amizadeId)
                .orElseThrow(() -> new RuntimeException("Solicitação não encontrada!"));

        // resposta pode ser "ACEITO" ou "RECUSADO"
        amizade.setStatus(resposta); 
        return amizadeRepository.save(amizade);
    }

    public List<Amizade> listarAmigosAtivos(Long clienteId) {
        return amizadeRepository.findByClienteIdAndStatus(clienteId, "ACEITO");
    }
}