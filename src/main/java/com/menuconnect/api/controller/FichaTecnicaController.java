package com.menuconnect.api.controller;

import com.menuconnect.api.model.FichaTecnica;
import com.menuconnect.api.service.FichaTecnicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fichatecnica")
public class FichaTecnicaController {

    @Autowired
    private FichaTecnicaService service;

    @PostMapping
    public ResponseEntity<FichaTecnica> adicionarIngrediente(@RequestBody FichaTecnica fichaTecnica) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.adicionarIngredienteAoProduto(fichaTecnica));
    }

    @GetMapping("/produto/{produtoId}")
    public ResponseEntity<List<FichaTecnica>> buscarReceita(@PathVariable Long produtoId) {
        return ResponseEntity.ok(service.buscarReceitaDoProduto(produtoId));
    }
}