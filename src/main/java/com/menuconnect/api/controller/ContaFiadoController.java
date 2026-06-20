package com.menuconnect.api.controller;

import com.menuconnect.api.model.LancamentoFiado;
import com.menuconnect.api.service.ContaFiadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/fiados")
public class ContaFiadoController {

    @Autowired
    private ContaFiadoService service;

    @PostMapping("/conta/{contaId}/comprar")
    public ResponseEntity<LancamentoFiado> pendurarNaConta(
            @PathVariable Long contaId, 
            @RequestParam BigDecimal valorCompra) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarCompraFiado(contaId, valorCompra));
    }

    @PostMapping("/conta/{contaId}/pagar")
    public ResponseEntity<LancamentoFiado> pagarDivida(
            @PathVariable Long contaId, 
            @RequestParam BigDecimal valorPago) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.abaterDivida(contaId, valorPago));
    }
}