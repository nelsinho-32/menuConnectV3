package com.menuconnect.api.controller;

import com.menuconnect.api.model.NotaFiscal;
import com.menuconnect.api.service.NotaFiscalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notasfiscais")
public class NotaFiscalController {

    @Autowired
    private NotaFiscalService service;

    @PostMapping("/emitir")
    public ResponseEntity<NotaFiscal> emitir(@RequestBody NotaFiscal nota) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.solicitarEmissao(nota));
    }
}