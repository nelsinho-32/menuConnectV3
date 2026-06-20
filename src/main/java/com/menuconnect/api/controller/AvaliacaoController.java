package com.menuconnect.api.controller;

import com.menuconnect.api.model.Avaliacao;
import com.menuconnect.api.service.AvaliacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/avaliacoes")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoService service;

    @PostMapping
    public ResponseEntity<Avaliacao> avaliar(@RequestBody Avaliacao avaliacao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarAvaliacao(avaliacao));
    }

    @GetMapping("/estabelecimento/{estabelecimentoId}")
    public ResponseEntity<List<Avaliacao>> listarDoLocal(@PathVariable Long estabelecimentoId) {
        return ResponseEntity.ok(service.listarAvaliacoesDoLocal(estabelecimentoId));
    }
}