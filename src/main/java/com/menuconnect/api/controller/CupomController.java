package com.menuconnect.api.controller;

import com.menuconnect.api.model.Cupom;
import com.menuconnect.api.service.CupomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cupons")
public class CupomController {

    @Autowired
    private CupomService service;

    @PostMapping
    public ResponseEntity<Cupom> criar(@RequestBody Cupom cupom) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criarCupom(cupom));
    }

    @PostMapping("/validar")
    public ResponseEntity<Cupom> aplicarCupom(@RequestParam String codigo, @RequestParam Long estabelecimentoId) {
        return ResponseEntity.ok(service.validarEAplicarCupom(codigo, estabelecimentoId));
    }
}