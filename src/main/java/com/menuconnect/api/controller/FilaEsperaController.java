package com.menuconnect.api.controller;

import com.menuconnect.api.model.FilaEspera;
import com.menuconnect.api.service.FilaEsperaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/fila")
public class FilaEsperaController {

    @Autowired
    private FilaEsperaService service;

    @PostMapping
    public ResponseEntity<FilaEspera> entrarNaFila(@RequestBody FilaEspera fila) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarAFila(fila));
    }

    @PutMapping("/{id}/notificar")
    public ResponseEntity<FilaEspera> chamarCliente(@PathVariable Long id) {
        return ResponseEntity.ok(service.notificarCliente(id));
    }
}