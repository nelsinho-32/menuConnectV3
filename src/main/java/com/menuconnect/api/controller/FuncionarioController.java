package com.menuconnect.api.controller;

import com.menuconnect.api.model.Funcionario;
import com.menuconnect.api.service.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/funcionarios")
public class FuncionarioController {

    @Autowired
    private FuncionarioService service;

    @PostMapping
    public ResponseEntity<Funcionario> contratar(@RequestBody Funcionario funcionario) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.contratarFuncionario(funcionario));
    }

    @GetMapping("/estabelecimento/{estabelecimentoId}")
    public ResponseEntity<List<Funcionario>> listarEquipe(
            @PathVariable Long estabelecimentoId, 
            @RequestParam String cargo) {
        return ResponseEntity.ok(service.listarEquipe(estabelecimentoId, cargo));
    }
}