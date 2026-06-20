package com.menuconnect.api.controller;

import com.menuconnect.api.model.Amizade;
import com.menuconnect.api.service.AmizadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amizades")
public class AmizadeController {

    @Autowired
    private AmizadeService service;

    @PostMapping("/solicitar/{clienteId}/{amigoId}")
    public ResponseEntity<Amizade> solicitar(@PathVariable Long clienteId, @PathVariable Long amigoId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.solicitarAmizade(clienteId, amigoId));
    }

    @PutMapping("/{id}/responder")
    public ResponseEntity<Amizade> responder(@PathVariable Long id, @RequestParam String resposta) {
        return ResponseEntity.ok(service.responderSolicitacao(id, resposta));
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Amizade>> listarAmigos(@PathVariable Long clienteId) {
        return ResponseEntity.ok(service.listarAmigosAtivos(clienteId));
    }
}