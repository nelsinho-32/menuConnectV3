package com.menuconnect.api.controller;

import com.menuconnect.api.model.Comanda;
import com.menuconnect.api.service.ComandaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/comandas")
public class ComandaController {

    @Autowired
    private ComandaService service;

    @PostMapping("/abrir")
    public ResponseEntity<Comanda> abrirComanda(@RequestBody Comanda comanda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.abrirComanda(comanda));
    }

    @PutMapping("/{id}/fechar")
    public ResponseEntity<Comanda> fecharComanda(@PathVariable Long id) {
        return ResponseEntity.ok(service.fecharComanda(id));
    }

    @GetMapping("/estabelecimento/{estabelecimentoId}/ativas")
    public ResponseEntity<List<Comanda>> listarAtivas(@PathVariable Long estabelecimentoId) {
        return ResponseEntity.ok(service.listarComandasAtivas(estabelecimentoId));
    }
}