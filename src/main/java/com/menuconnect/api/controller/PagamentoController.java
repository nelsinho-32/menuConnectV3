package com.menuconnect.api.controller;

import com.menuconnect.api.model.Pagamento;
import com.menuconnect.api.service.PagamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pagamentos")
public class PagamentoController {

    @Autowired
    private PagamentoService service;

    @PostMapping
    public ResponseEntity<Pagamento> pagar(@RequestBody Pagamento pagamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.processarPagamento(pagamento));
    }

    @GetMapping("/comanda/{comandaId}")
    public ResponseEntity<List<Pagamento>> listarDaComanda(@PathVariable Long comandaId) {
        return ResponseEntity.ok(service.listarPagamentosDaComanda(comandaId));
    }
}