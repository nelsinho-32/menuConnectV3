package com.menuconnect.api.service;

import com.menuconnect.api.model.Encontro;
import com.menuconnect.api.model.EncontroParticipante;
import com.menuconnect.api.repository.EncontroParticipanteRepository;
import com.menuconnect.api.repository.EncontroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EncontroService {

    @Autowired
    private EncontroRepository encontroRepository;

    @Autowired
    private EncontroParticipanteRepository participanteRepository;

    @Transactional
    public Encontro criarEncontro(Encontro encontro) {
        // Salva o evento principal
        Encontro encontroSalvo = encontroRepository.save(encontro);

        // O criador do evento já entra automaticamente como "CONFIRMADO"
        EncontroParticipante participante = new EncontroParticipante();
        participante.setEncontro(encontroSalvo);
        participante.setCliente(encontro.getCriador());
        participante.setStatusPresenca("CONFIRMADO");
        participanteRepository.save(participante);

        return encontroSalvo;
    }

    public EncontroParticipante convidarAmigo(EncontroParticipante convite) {
        // Antes de convidar, o sistema poderia verificar na AmizadeService 
        // se eles realmente são amigos (status "ACEITO").
        convite.setStatusPresenca("CONVIDADO");
        return participanteRepository.save(convite);
    }
    
    // Método que o Frontend vai chamar se um amigo tentar adicionar um prato ao encontro
    public boolean validarPermissaoModificacao(Long encontroId) {
        Encontro encontro = encontroRepository.findById(encontroId).orElseThrow();
        return encontro.getPermiteModificacaoAmigos();
    }
}