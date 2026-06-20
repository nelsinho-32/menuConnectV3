package com.menuconnect.api.controller;

import com.menuconnect.api.model.Insumo;
import com.menuconnect.api.service.InsumoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/insumos")
public class InsumoController {

    @Autowired
    private InsumoService service;

    @PostMapping
    public ResponseEntity<Insumo> cadastrar(@RequestBody Insumo insumo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrarInsumo(insumo));
    }

    @GetMapping("/estabelecimento/{estabelecimentoId}")
    public ResponseEntity<List<Insumo>> listarEstoque(@PathVariable Long estabelecimentoId) {
        return ResponseEntity.ok(service.listarPorEstabelecimento(estabelecimentoId));
    }

    @PutMapping("/{id}/atualizar-quantidade")
    public ResponseEntity<Insumo> ajustarEstoque(@PathVariable Long id, @RequestParam BigDecimal novaQuantidade) {
        return ResponseEntity.ok(service.atualizarQuantidade(id, novaQuantidade));
    }
}