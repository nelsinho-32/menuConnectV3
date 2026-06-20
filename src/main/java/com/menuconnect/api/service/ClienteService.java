package com.menuconnect.api.service;

import com.menuconnect.api.model.Cliente;
import com.menuconnect.api.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository repository;

    public Cliente cadastrarCliente(Cliente cliente) {
        // Regra: O cliente já deve vir com um Usuario (login/senha) atrelado a ele
        if (cliente.getUsuario() == null) {
            throw new IllegalArgumentException("O cliente precisa ter um usuário de acesso vinculado.");
        }
        return repository.save(cliente);
    }

    public Cliente buscarPorUsuarioId(Long usuarioId) {
        return repository.findByUsuarioId(usuarioId);
    }
}