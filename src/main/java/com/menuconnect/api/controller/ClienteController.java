package com.menuconnect.api.controller;

import com.menuconnect.api.model.Cliente;
import com.menuconnect.api.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> cadastrar(@RequestBody Cliente cliente) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarCliente(cliente));
    }

    @GetMapping("/usuario/{usuarioId}")
    public ResponseEntity<Cliente> buscarPerfil(@PathVariable Long usuarioId) {
        return ResponseEntity.ok(service.buscarPorUsuarioId(usuarioId));
    }
}