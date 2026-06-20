package com.menuconnect.api.controller;

import com.menuconnect.api.model.Entrega;
import com.menuconnect.api.service.EntregaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/entregas")
public class EntregaController {

    @Autowired
    private EntregaService service;

    @PostMapping
    public ResponseEntity<Entrega> registrar(@RequestBody Entrega entrega) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarNovaEntrega(entrega));
    }

    @PutMapping("/{id}/despachar/{funcionarioId}")
    public ResponseEntity<Entrega> despachar(@PathVariable Long id, @PathVariable Long funcionarioId) {
        return ResponseEntity.ok(service.despacharComMotoboy(id, funcionarioId));
    }
    
    @PutMapping("/{id}/confirmar")
    public ResponseEntity<Entrega> confirmar(@PathVariable Long id) {
        return ResponseEntity.ok(service.confirmarEntrega(id));
    }
}