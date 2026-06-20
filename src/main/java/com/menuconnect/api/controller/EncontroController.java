package com.menuconnect.api.controller;

import com.menuconnect.api.model.Encontro;
import com.menuconnect.api.model.EncontroParticipante;
import com.menuconnect.api.service.EncontroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/encontros")
public class EncontroController {

    @Autowired
    private EncontroService service;

    @PostMapping
    public ResponseEntity<Encontro> criarEncontro(@RequestBody Encontro encontro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarEncontro(encontro));
    }

    @PostMapping("/convidar")
    public ResponseEntity<EncontroParticipante> convidarAmigo(@RequestBody EncontroParticipante convite) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.convidarAmigo(convite));
    }

    @GetMapping("/{id}/permite-modificacao")
    public ResponseEntity<Boolean> verificarPermissao(@PathVariable Long id) {
        return ResponseEntity.ok(service.validarPermissaoModificacao(id));
    }
}