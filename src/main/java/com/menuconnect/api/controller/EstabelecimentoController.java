package com.menuconnect.api.controller;

import com.menuconnect.api.model.Estabelecimento;
import com.menuconnect.api.service.EstabelecimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/estabelecimentos") // Esta será a URL base
public class EstabelecimentoController {

    @Autowired
    private EstabelecimentoService service;

    // POST: Rota para o Frontend enviar dados e cadastrar um local
    @PostMapping
    public ResponseEntity<Estabelecimento> cadastrar(@RequestBody Estabelecimento estabelecimento) {
        Estabelecimento novoEstabelecimento = service.criarEstabelecimento(estabelecimento);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoEstabelecimento);
    }

    // GET: Rota para o App/Site listar os locais na tela de "Exploração"
    @GetMapping
    public ResponseEntity<List<Estabelecimento>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    // GET: Rota para buscar detalhes de um local específico
    @GetMapping("/{id}")
    public ResponseEntity<Estabelecimento> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }
}