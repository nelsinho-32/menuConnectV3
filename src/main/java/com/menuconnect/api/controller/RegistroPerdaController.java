package com.menuconnect.api.controller;

import com.menuconnect.api.model.RegistroPerda;
import com.menuconnect.api.service.RegistroPerdaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/perdas")
public class RegistroPerdaController {

    @Autowired
    private RegistroPerdaService service;

    @PostMapping
    public ResponseEntity<RegistroPerda> registrar(@RequestBody RegistroPerda perda) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrarPerda(perda));
    }
}