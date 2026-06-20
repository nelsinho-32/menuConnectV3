package com.menuconnect.api.controller;

import com.menuconnect.api.model.Produto;
import com.menuconnect.api.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @PostMapping
    public ResponseEntity<Produto> cadastrar(@RequestBody Produto produto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.salvarProduto(produto));
    }

    @GetMapping("/estabelecimento/{estabelecimentoId}")
    public ResponseEntity<List<Produto>> listarCardapio(@PathVariable Long estabelecimentoId) {
        return ResponseEntity.ok(service.listarPorEstabelecimento(estabelecimentoId));
    }
}